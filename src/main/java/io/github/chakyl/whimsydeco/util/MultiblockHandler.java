package io.github.chakyl.whimsydeco.util;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author skyjay1
 * [https://github.com/skyjay1/Tanuki-Decor/blob/main-1.20.1/src/main/java/tanukidecor/util/MultiblockHandler.java]
 * Used with permission under the GNU LGPLv3 license
 */
@Immutable
public class MultiblockHandler {

    public static final Direction ORIGIN_DIRECTION = Direction.NORTH;

    protected static final String WIDTH = "width";
    protected static final String HEIGHT = "height";
    protected static final String DEPTH = "depth";

    /* The X index property */
    protected static final IntegerProperty WIDTH_1_2 = IntegerProperty.create(WIDTH, 1, 2);
    protected static final IntegerProperty WIDTH_0_2 = IntegerProperty.create(WIDTH, 0, 2);
    /* The Y index property */
    protected static final IntegerProperty HEIGHT_1_2 = IntegerProperty.create(HEIGHT, 1, 2);
    protected static final IntegerProperty HEIGHT_0_2 = IntegerProperty.create(HEIGHT, 0, 2);
    /* The Z index property */
    protected static final IntegerProperty DEPTH_1_2 = IntegerProperty.create(DEPTH, 1, 2);
    protected static final IntegerProperty DEPTH_0_2 = IntegerProperty.create(DEPTH, 0, 2);

    protected static final IntegerProperty[] WIDTH_BY_MAX_VALUE = new IntegerProperty[]{null, WIDTH_1_2, WIDTH_0_2};
    protected static final IntegerProperty[] HEIGHT_BY_MAX_VALUE = new IntegerProperty[]{null, HEIGHT_1_2, HEIGHT_0_2};
    protected static final IntegerProperty[] DEPTH_BY_MAX_VALUE = new IntegerProperty[]{null, DEPTH_1_2, DEPTH_0_2};


    protected final @Nullable IntegerProperty widthProperty;
    protected final @Nullable IntegerProperty heightProperty;
    protected final @Nullable IntegerProperty depthProperty;

    protected final Vec3i dimensions;
    protected final Vec3i minIndex;
    protected final Vec3i maxIndex;
    protected final Map<Direction, BoundingBox> bounds;

    public MultiblockHandler(final int width, final int height, final int depth) {
        // validate dimensions
        if (width < 1 || height < 1 || depth < 1) {
            throw new IllegalArgumentException(String.format("[MultiblockHandler] width, height, and depth must be greater than zero! Provided [{}, {}, {}]", width, height, depth));
        }
        this.dimensions = new Vec3i(width, height, depth);
        this.minIndex = new Vec3i(-(width - 1) / 2, -(height - 1) / 2, -(depth - 1) / 2);
        this.maxIndex = new Vec3i(width / 2, height / 2, depth / 2);
        this.widthProperty = getWidthProperty(width);
        this.heightProperty = getHeightProperty(height);
        this.depthProperty = getDepthProperty(depth);
        final BoundingBox boundingBox = BoundingBox.fromCorners(minIndex, maxIndex);
        this.bounds = createRotatedBoundingBoxMap(boundingBox, ORIGIN_DIRECTION);
    }

    /// / PROPERTY HELPER METHODS ////

    public static @Nullable IntegerProperty getWidthProperty(final int maxWidth) {
        final int index = Mth.clamp(maxWidth - 1, 0, WIDTH_BY_MAX_VALUE.length - 1);
        return WIDTH_BY_MAX_VALUE[index];
    }

    public static @Nullable IntegerProperty getHeightProperty(final int maxHeight) {
        final int index = Mth.clamp(maxHeight - 1, 0, HEIGHT_BY_MAX_VALUE.length - 1);
        return HEIGHT_BY_MAX_VALUE[index];
    }

    public static @Nullable IntegerProperty getDepthProperty(final int maxDepth) {
        final int index = Mth.clamp(maxDepth - 1, 0, DEPTH_BY_MAX_VALUE.length - 1);
        return DEPTH_BY_MAX_VALUE[index];
    }


    /**
     * @param boundingBox
     * @param from
     * @return a map containing bounding boxes for each horizontal direction
     */
    protected static Map<Direction, BoundingBox> createRotatedBoundingBoxMap(final BoundingBox boundingBox, final Direction from) {
        final Map<Direction, BoundingBox> map = new EnumMap<>(Direction.class);
        map.put(from, boundingBox);
        BoundingBox box = boundingBox;
        for (int i = 0; i < 3; i++) {
            Direction direction = Direction.from2DDataValue(from.get2DDataValue() + i + 1);
            box = new BoundingBox(1 - box.maxZ(), box.minY(), box.minX(), 1 - box.minZ(), box.maxY(), box.maxX());
            map.put(direction, box);
        }
        return map;
    }

}