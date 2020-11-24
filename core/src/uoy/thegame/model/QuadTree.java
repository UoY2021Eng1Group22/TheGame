package uoy.thegame.model;

// collision detection data structure (extension of btree, adapted from following links)
// https://gamedevelopment.tutsplus.com/tutorials/quick-tip-use-quadtrees-to-detect-likely-collisions-in-2d-space--gamedev-374
// https://gamedevelopment.tutsplus.com/tutorials/collision-detection-using-the-separating-axis-theorem--gamedev-169

import com.badlogic.gdx.math.Rectangle;
import uoy.thegame.entitymodel.Entity;

import java.util.ArrayList;

/**
 * QuadTree is a data structure for efficient collision detection between actors in a 2d space.
 * <p>
 * The code is modified to work with LibGdx math, and the custom Entity(Actor) model.
 * <p>
 * Ref:
 * https://gamedevelopment.tutsplus.com/tutorials/quick-tip-use-quadtrees-to-detect-likely-collisions-in-2d-space--gamedev-374
 * https://gamedevelopment.tutsplus.com/tutorials/collision-detection-using-the-separating-axis-theorem--gamedev-169
 */
class QuadTree {

    /**
     * The maximum number of objects a node can hold.
     */
    private final int quadrantObjectThreshold = 10;

    /**
     * The maximum depth the tree can go.
     */
    private final int maxTreeDepth = 5;

    /**
     * Current node level.
     */
    private final int currentlevel;

    /**
     *
     */
    private final ArrayList<Entity> objects;

    /**
     * Tree node boundaries
     */
    private final Rectangle bounds;

    /**
     * Sub-nodes / quadrants
     */
    private final QuadTree[] nodes;


    /**
     * @param level  the current level. (should be 0 to start with)
     * @param bounds the boundaries of the QuadTree. (should be the dimension of the stage to begin with.)
     */
    QuadTree(int level, Rectangle bounds) {
        this.currentlevel = level;
        this.bounds = bounds;
        this.objects = new ArrayList<>();
        this.nodes = new QuadTree[4];
    }

    /**
     * Clear the quadtree.
     */
    void clear() {

    }

}
