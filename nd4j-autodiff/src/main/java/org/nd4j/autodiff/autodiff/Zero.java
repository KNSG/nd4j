package org.nd4j.autodiff.autodiff;

import org.nd4j.autodiff.AbstractIdentityFactory;
import org.nd4j.autodiff.Field;
import org.nd4j.autodiff.graph.graph.Graph;
import org.nd4j.autodiff.opstate.NDArrayInformation;
import org.nd4j.autodiff.opstate.OpState;
import org.nd4j.linalg.api.ops.impl.transforms.arithmetic.AddOp;
import org.nd4j.linalg.api.ops.impl.transforms.arithmetic.MulOp;


public class Zero<X extends Field<X>> extends Constant<X> {


    public Zero(Graph<NDArrayInformation,OpState> graph,AbstractIdentityFactory<X> i_factory) {
        super(graph,i_factory.zero(), i_factory);
    }

    @Override
    public DifferentialFunction<X> plus(DifferentialFunction<X> i_v) {
        addEdge(new AddOp().name());
        return i_v;
    }

    @Override
    protected DifferentialFunction<X> plused(DifferentialFunction<X> i_v) {
        addEdge(new AddOp().name());
        return i_v;
    }

    @Override
    // public DifferentialFunction<X> mul(DifferentialFunction<X> i_v) {
    public Zero<X> mul(DifferentialFunction<X> i_v) {
        addEdge(new MulOp().name());
        return this;
    }

    @Override
    // protected DifferentialFunction<X> muled(DifferentialFunction<X> i_v) {
    protected Zero<X> muled(DifferentialFunction<X> i_v) {
        addEdge(new MulOp().name());
        return this;
    }

    @Override
    // public DifferentialFunction<X> inverse() {
    public Constant<X> inverse() {
        // TODO
        throw new UnsupportedOperationException();
    }

    @Override
    // public DifferentialFunction<X> negate() {
    // public Constant<X> negate() {
    public Zero<X> negate() {
        addEdge(new org.nd4j.linalg.api.ops.impl.transforms.Negative().name());
        return this;
    }

}
