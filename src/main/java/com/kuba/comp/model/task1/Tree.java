package com.kuba.comp.model.task1;

import java.util.List;

public abstract class Tree {
    protected Trunk trunk;
    protected List<Branch> branches;
    protected List<ILeaf> leaves;
    protected List<IFruit> fruits;

    public abstract void grow();

    public abstract void growFruit();
    public abstract void growLeaves();

    public abstract void produceOxygen();

    public abstract void shedLeaves();
    public abstract void dropFruits();

    public abstract void hibernate();
}
