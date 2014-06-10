package eu.lestard.advanced_bindings.api;

import org.junit.Test;

import static eu.lestard.advanced_bindings.api.MathBindingsTestHelper.*;


/**
 * This test verifies the behaviour of all bindings from {@link eu.lestard.advanced_bindings.api.MathBindings} class.
 *
 * The purpose of this test class is NOT to verify the calculation logic of {@link java.lang.Math}
 * but to only verify that the created bindings are behaving correctly.
 *
 * Therefore I only verify that every binding has the same value as the corresponding method of the Math class with
 * some
 * example values.
 */
public class MathBindingsTest {

    @Test
    public void testAbs() {
        testDoubleBinding(MathBindings::abs, Math::abs, 10.13, -23.4);
        testFloatBinding(MathBindings::abs, Math::abs, 10.13f, -23.4f);
        testIntegerBinding(MathBindings::abs, Math::abs, 20, -13);
        testLongBinding(MathBindings::abs, Math::abs, 20l, -13l);
    }

    @Test
    public void testAddExact(){
        testIntegerBinding2Args1(MathBindings::addExact, Math::addExact, new Args<>(12, 4), new Args<>(0, 1), new Args<>(-123, 234));
        testIntegerBinding2Args2(MathBindings::addExact, Math::addExact, new Args<>(12, 4), new Args<>(0, 1), new Args<>(-123, 234));
        testIntegerBinding2Args3(MathBindings::addExact, Math::addExact, new Args<>(12, 4), new Args<>(0, 1), new Args<>(-123, 234));

        testLongBinding2Args1(MathBindings::addExact, Math::addExact, new Args<>(12l, 4l), new Args<>(0l, 1l), new Args<>(-123l, 234l));
        testLongBinding2Args2(MathBindings::addExact, Math::addExact, new Args<>(12l, 4l), new Args<>(0l, 1l), new Args<>(-123l, 234l));
        testLongBinding2Args3(MathBindings::addExact, Math::addExact, new Args<>(12l, 4l), new Args<>(0l, 1l), new Args<>(-123l, 234l));

    }

    @Test
    public void testAcos() {
        testDoubleBinding(MathBindings::acos, Math::acos, 0, -1, 1, Double.NaN, 1.2);
    }


    @Test
    public void testAsin(){
        testDoubleBinding(MathBindings::acos, Math::acos, Math.PI, -Math.PI, 0, 1, -1, 1.45, Double.NaN);
    }

    @Test
    public void testAtan(){
        testDoubleBinding(MathBindings::atan, Math::atan, Math.PI, -Math.PI, 0, 1, -1, 1.45, Double.NaN);
    }

    @Test
    public void testCbrt(){
        testDoubleBinding(MathBindings::cbrt, Math::cbrt, 0, -12.3, 12.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testCeil(){
        testDoubleBinding(MathBindings::ceil, Math::ceil, 0, 0.14, -0.14, 1, 14, 12.3, -12.4, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testCos(){
        testDoubleBinding(MathBindings::cos, Math::cos, 0, 1, -1, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testCosh(){
        testDoubleBinding(MathBindings::cosh, Math::cosh, 0, 1, -1, Math.PI, -Math.PI,Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testDecrementExact(){
        testIntegerBinding(MathBindings::decrementExact, Math::decrementExact, -10, -1, 0, 1, 10);
        testLongBinding(MathBindings::decrementExact, Math::decrementExact, -10l, -1l, 0l, 1l, 10l);
    }

    @Test
    public void testExp(){
        testDoubleBinding(MathBindings::exp, Math::exp, -1, 0, 1, 10, 13.402, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testExpm1(){
        testDoubleBinding(MathBindings::expm1, Math::expm1, -1, 0, 1, 10, 13.402, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testFloor(){
        testDoubleBinding(MathBindings::floor, Math::floor, -12.13, -1.23, -1, 0, 1, 1.23, 1.98, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }


    @Test
    public void testFloorDiv(){
        testIntegerBinding2Args1(MathBindings::floorDiv, Math::floorDiv, new Args<>(4, 3), new Args<>(-4, 3));
        testIntegerBinding2Args2(MathBindings::floorDiv, Math::floorDiv, new Args<>(4, 3), new Args<>(-4, 3));
        testIntegerBinding2Args3(MathBindings::floorDiv, Math::floorDiv, new Args<>(4, 3), new Args<>(-4, 3));

        testLongBinding2Args1(MathBindings::floorDiv, Math::floorDiv, new Args<>(4l, 3l), new Args<>(-4l, 3l));
        testLongBinding2Args2(MathBindings::floorDiv, Math::floorDiv, new Args<>(4l, 3l), new Args<>(-4l, 3l));
        testLongBinding2Args3(MathBindings::floorDiv, Math::floorDiv, new Args<>(4l, 3l), new Args<>(-4l, 3l));
    }

    @Test
    public void testFloorMod(){
        testIntegerBinding2Args1(MathBindings::floorMod, Math::floorMod, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, -3));
        testIntegerBinding2Args2(MathBindings::floorMod, Math::floorMod, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, -3));
        testIntegerBinding2Args3(MathBindings::floorMod, Math::floorMod, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, -3));

        testLongBinding2Args1(MathBindings::floorMod, Math::floorMod, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, -3l));
        testLongBinding2Args2(MathBindings::floorMod, Math::floorMod, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, -3l));
        testLongBinding2Args3(MathBindings::floorMod, Math::floorMod, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, -3l));
    }


    @Test
    public void testIncrementExact(){
        testIntegerBinding(MathBindings::incrementExact, Math::incrementExact, -10, -1, 0, 1, 10);
        testLongBinding(MathBindings::incrementExact, Math::incrementExact, -10l, -1l, 0l, 1l, 10l);
    }

    @Test
    public void testLog(){
        testDoubleBinding(MathBindings::log, Math::log, -12.3, -1, 0, 1, 12.3, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY );
    }

    @Test
    public void testLog10(){
        testDoubleBinding(MathBindings::log10, Math::log10, -12.3, -1, 0, 1, 12.3, 100, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY );
    }

    @Test
    public void testLog1p(){
        testDoubleBinding(MathBindings::log1p, Math::log1p, -12.3, -1, 0, 1, 12.3, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY );
    }


    @Test
    public void testMax(){
        testIntegerBinding2Args1(MathBindings::max, Math::max, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args2(MathBindings::max, Math::max, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args3(MathBindings::max, Math::max, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));

        testLongBinding2Args1(MathBindings::max, Math::max, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args2(MathBindings::max, Math::max, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args3(MathBindings::max, Math::max, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
    }

    @Test
    public void testMin(){
        testIntegerBinding2Args1(MathBindings::min, Math::min, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args2(MathBindings::min, Math::min, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args3(MathBindings::min, Math::min, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));

        testLongBinding2Args1(MathBindings::min, Math::min, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args2(MathBindings::min, Math::min, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args3(MathBindings::min, Math::min, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
    }


    @Test
    public void testMultiplyExact(){
        testIntegerBinding2Args1(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args2(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args3(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));

        testLongBinding2Args1(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args2(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args3(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
    }


    @Test
    public void testNegateExact(){
        testIntegerBinding(MathBindings::negateExact, Math::negateExact, -10, -1, 0, 1, 10);
        testLongBinding(MathBindings::negateExact, Math::negateExact, -10l, -1l, 0l, 1l, 10l);
    }

    @Test
    public void testNextDown(){
        testDoubleBinding(MathBindings::nextDown, Math::nextDown, -12.3, -1, 0, 1, 12.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY );
        testFloatBinding(MathBindings::nextDown, Math::nextDown, -12.3f, -1f, 0f, 1f, 12.3f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY );
    }

    @Test
    public void testNextUp(){
        testDoubleBinding(MathBindings::nextUp, Math::nextUp, -12.3, -1, 0, 1, 12.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY );
        testFloatBinding(MathBindings::nextUp, Math::nextUp, -12.3f, -1f, 0f, 1f, 12.3f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    @Test
    public void testRint(){
        testDoubleBinding(MathBindings::rint, Math::rint, -1, 0, 1, 1.12, 1.89, 1.5, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testSignum(){
        testDoubleBinding(MathBindings::signum, Math::signum, -1, -1.23, -0.23, 0, 0.23, -1.23, 1, Double.NaN);
        testFloatBinding(MathBindings::signum, Math::signum, -1f, -1.23f, -0.23f, 0f, 0.23f, -1.23f, 1f, Float.NaN);
    }


    @Test
    public void testSin(){
        testDoubleBinding(MathBindings::sin, Math::sin, -1, 0, 1, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testSinh(){
        testDoubleBinding(MathBindings::sinh, Math::sinh, -1, 0, 1, Math.PI, -Math.PI, Double.NaN );
    }

    @Test
    public void testSqrt(){
        testDoubleBinding(MathBindings::sqrt, Math::sqrt, -12, -10.34, -1, 0, 1, 10.34, 12, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testSubtractExact(){
        testIntegerBinding2Args1(MathBindings::subtractExact, Math::subtractExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args2(MathBindings::subtractExact, Math::subtractExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args3(MathBindings::subtractExact, Math::subtractExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));

        testLongBinding2Args1(MathBindings::subtractExact, Math::subtractExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args2(MathBindings::subtractExact, Math::subtractExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args3(MathBindings::subtractExact, Math::subtractExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
    }

    @Test
    public void testTan(){
        testDoubleBinding(MathBindings::tan, Math::tan, -1, 0, 1, Math.PI, -Math.PI, Double.NaN );
    }

    @Test
    public void testTanh(){
        testDoubleBinding(MathBindings::tanh, Math::tanh, -1, 0, 1, Math.PI, -Math.PI, Double.NaN );
    }

    @Test
    public void testToDegrees(){
        testDoubleBinding(MathBindings::toDegrees, Math::toDegrees, -1, 0, 1, 90, -90, 180, 360, 359, Double.NaN );
    }

    @Test
    public void testToRadians(){
        testDoubleBinding(MathBindings::toRadians, Math::toRadians, -1, 0, 1, Math.PI, 2*Math.PI, Double.NaN );
    }

    @Test
    public void testUlp(){
        testDoubleBinding(MathBindings::ulp, Math::ulp, 0, 1, 102.3, -102.3, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        testFloatBinding(MathBindings::ulp, Math::ulp, 0f, 1f, 102.3f, -102.3f, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }

}
