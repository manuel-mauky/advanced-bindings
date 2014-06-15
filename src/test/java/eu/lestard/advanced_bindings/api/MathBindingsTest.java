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
        testDoubleArgBinding(MathBindings::abs, Math::abs, 10.13, -23.4);
        testFloatArgBinding(MathBindings::abs, Math::abs, 10.13f, -23.4f);
        testIntegerArgBinding(MathBindings::abs, Math::abs, 20, -13);
        testLongArgBinding(MathBindings::abs, Math::abs, 20l, -13l);

    }

    @Test
    public void testAddExact() {
        testIntegerBinding2Args1(MathBindings::addExact, Math::addExact, new Args<>(12, 4), new Args<>(0, 1), new Args<>(-123, 234));
        testIntegerBinding2Args2(MathBindings::addExact, Math::addExact, new Args<>(12, 4), new Args<>(0, 1), new Args<>(-123, 234));
        testIntegerBinding2Args3(MathBindings::addExact, Math::addExact, new Args<>(12, 4), new Args<>(0, 1), new Args<>(-123, 234));

        testLongBinding2Args1(MathBindings::addExact, Math::addExact, new Args<>(12l, 4l), new Args<>(0l, 1l), new Args<>(-123l, 234l));
        testLongBinding2Args2(MathBindings::addExact, Math::addExact, new Args<>(12l, 4l), new Args<>(0l, 1l), new Args<>(-123l, 234l));
        testLongBinding2Args3(MathBindings::addExact, Math::addExact, new Args<>(12l, 4l), new Args<>(0l, 1l), new Args<>(-123l, 234l));

    }

    @Test
    public void testAcos() {
        testDoubleArgBinding(MathBindings::acos, Math::acos, 0d, -1d, 1d, Double.NaN, 1.2);
    }


    @Test
    public void testAsin() {
        testDoubleArgBinding(MathBindings::asin, Math::asin, Math.PI, -Math.PI, 0d, 1d, -1d, 1.45, Double.NaN);
    }

    @Test
    public void testAtan() {
        testDoubleArgBinding(MathBindings::atan, Math::atan, Math.PI, -Math.PI, 0d, 1d, -1d, 1.45, Double.NaN);
    }

    @Test
    public void testAtan2() {
        testDoubleBinding2Args1(MathBindings::atan2, Math::atan2,
            new Args<>(1.2, 3.2),
            new Args<>(0d, 3.2),
            new Args<>(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
            new Args<>(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
            new Args<>(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Args<>(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Args<>(Double.NaN, 1.2));
        testDoubleBinding2Args2(MathBindings::atan2, Math::atan2,
            new Args<>(1.2, 3.2),
            new Args<>(0d, 3.2),
            new Args<>(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
            new Args<>(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
            new Args<>(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Args<>(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Args<>(Double.NaN, 1.2));
        testDoubleBinding2Args3(MathBindings::atan2, Math::atan2,
            new Args<>(1.2, 3.2),
            new Args<>(0d, 3.2),
            new Args<>(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
            new Args<>(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY),
            new Args<>(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Args<>(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Args<>(Double.NaN, 1.2));
    }

    @Test
    public void testCbrt() {
        testDoubleArgBinding(MathBindings::cbrt, Math::cbrt, 0d, -12.3, 12.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testCeil() {
        testDoubleArgBinding(MathBindings::ceil, Math::ceil, 0d, 0.14, -0.14, 1d, 14d, 12.3, -12.4, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testCopySign() {
        testDoubleBinding2Args1(MathBindings::copySign, Math::copySign, new Args<>(-12.3, 123.2), new Args<>(12.3, -123.2), new Args<>(Double.NaN, 123.2));
        testDoubleBinding2Args2(MathBindings::copySign, Math::copySign, new Args<>(-12.3, 123.2), new Args<>(12.3, -123.2), new Args<>(Double.NaN, 123.2));
        testDoubleBinding2Args3(MathBindings::copySign, Math::copySign, new Args<>(-12.3, 123.2), new Args<>(12.3, -123.2), new Args<>(Double.NaN, 123.2));

        testFloatBinding2Args1(MathBindings::copySign, Math::copySign, new Args<>(-12.3f, 123.2f), new Args<>(12.3f, -123.2f), new Args<>(Float.NaN, 123.2f));
        testFloatBinding2Args2(MathBindings::copySign, Math::copySign, new Args<>(-12.3f, 123.2f), new Args<>(12.3f, -123.2f), new Args<>(Float.NaN, 123.2f));
        testFloatBinding2Args3(MathBindings::copySign, Math::copySign, new Args<>(-12.3f, 123.2f), new Args<>(12.3f, -123.2f), new Args<>(Float.NaN, 123.2f));
    }


    @Test
    public void testCos() {
        testDoubleArgBinding(MathBindings::cos, Math::cos, 0d, 1d, -1d, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testCosh() {
        testDoubleArgBinding(MathBindings::cosh, Math::cosh, 0d, 1d, -1d, Math.PI, -Math.PI, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testDecrementExact() {
        testIntegerArgBinding(MathBindings::decrementExact, Math::decrementExact, -10, -1, 0, 1, 10);
        testLongArgBinding(MathBindings::decrementExact, Math::decrementExact, -10l, -1l, 0l, 1l, 10l);
    }

    @Test
    public void testExp() {
        testDoubleArgBinding(MathBindings::exp, Math::exp, -1d, 0d, 1d, 10d, 13.402, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testExpm1() {
        testDoubleArgBinding(MathBindings::expm1, Math::expm1, -1d, 0d, 1d, 10d, 13.402, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testFloor() {
        testDoubleArgBinding(MathBindings::floor, Math::floor, -12.13, -1.23, -1d, 0d, 1d, 1.23, 1.98, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }


    @Test
    public void testFloorDiv() {
        testIntegerBinding2Args1(MathBindings::floorDiv, Math::floorDiv, new Args<>(4, 3), new Args<>(-4, 3));
        testIntegerBinding2Args2(MathBindings::floorDiv, Math::floorDiv, new Args<>(4, 3), new Args<>(-4, 3));
        testIntegerBinding2Args3(MathBindings::floorDiv, Math::floorDiv, new Args<>(4, 3), new Args<>(-4, 3));

        testLongBinding2Args1(MathBindings::floorDiv, Math::floorDiv, new Args<>(4l, 3l), new Args<>(-4l, 3l));
        testLongBinding2Args2(MathBindings::floorDiv, Math::floorDiv, new Args<>(4l, 3l), new Args<>(-4l, 3l));
        testLongBinding2Args3(MathBindings::floorDiv, Math::floorDiv, new Args<>(4l, 3l), new Args<>(-4l, 3l));
    }

    @Test
    public void testFloorMod() {
        testIntegerBinding2Args1(MathBindings::floorMod, Math::floorMod, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, -3));
        testIntegerBinding2Args2(MathBindings::floorMod, Math::floorMod, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, -3));
        testIntegerBinding2Args3(MathBindings::floorMod, Math::floorMod, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, -3));

        testLongBinding2Args1(MathBindings::floorMod, Math::floorMod, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, -3l));
        testLongBinding2Args2(MathBindings::floorMod, Math::floorMod, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, -3l));
        testLongBinding2Args3(MathBindings::floorMod, Math::floorMod, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, -3l));
    }


    @Test
    public void testGetExponent() {
        testDoubleArgBinding(MathBindings::getExponent, Math::getExponent, 2.1, 2.34, Double.NaN, Double.POSITIVE_INFINITY, 0d);
        testFloatArgBinding(MathBindings::getExponent, Math::getExponent, 2.1f, 2.34f, Float.NaN, Float.POSITIVE_INFINITY, 0f);
    }


    @Test
    public void testHypot() {
        testDoubleBinding2Args1(MathBindings::hypot, Math::hypot, new Args<>(1.2, 0.2), new Args<>(Double.POSITIVE_INFINITY, 0.2), new Args<>(1.2, Double.NEGATIVE_INFINITY), new Args<>(Double.NaN, 0.2));
        testDoubleBinding2Args2(MathBindings::hypot, Math::hypot, new Args<>(1.2, 0.2), new Args<>(Double.POSITIVE_INFINITY, 0.2), new Args<>(1.2, Double.NEGATIVE_INFINITY), new Args<>(Double.NaN, 0.2));
        testDoubleBinding2Args3(MathBindings::hypot, Math::hypot, new Args<>(1.2, 0.2), new Args<>(Double.POSITIVE_INFINITY, 0.2), new Args<>(1.2, Double.NEGATIVE_INFINITY), new Args<>(Double.NaN, 0.2));
    }

    @Test
    public void testIEEEremainder() {
        testDoubleBinding2Args1(MathBindings::IEEEremainder, Math::IEEEremainder,
            new Args<>(1.2, 0.2),
            new Args<>(Double.POSITIVE_INFINITY, 12.2),
            new Args<>(Double.NEGATIVE_INFINITY, 1.2),
            new Args<>(1.2, Double.POSITIVE_INFINITY),
            new Args<>(1.2, Double.NEGATIVE_INFINITY),
            new Args<>(1.2, 0d),
            new Args<>(0d, 1.2),
            new Args<>(Double.NaN, 1.2),
            new Args<>(1.2, Double.NaN));

        testDoubleBinding2Args2(MathBindings::IEEEremainder, Math::IEEEremainder,
            new Args<>(1.2, 0.2),
            new Args<>(Double.POSITIVE_INFINITY, 12.2),
            new Args<>(Double.NEGATIVE_INFINITY, 1.2),
            new Args<>(1.2, Double.POSITIVE_INFINITY),
            new Args<>(1.2, Double.NEGATIVE_INFINITY),
            new Args<>(1.2, 0d),
            new Args<>(0d, 1.2),
            new Args<>(Double.NaN, 1.2),
            new Args<>(1.2, Double.NaN));

        testDoubleBinding2Args3(MathBindings::IEEEremainder, Math::IEEEremainder,
            new Args<>(1.2, 0d),
            new Args<>(Double.POSITIVE_INFINITY, 12.2),
            new Args<>(Double.NEGATIVE_INFINITY, 1.2),
            new Args<>(1.2, Double.POSITIVE_INFINITY),
            new Args<>(1.2, Double.NEGATIVE_INFINITY),
            new Args<>(1.2, 0d),
            new Args<>(0d, 1.2),
            new Args<>(Double.NaN, 1.2),
            new Args<>(1.2, Double.NaN));
    }


    @Test
    public void testIncrementExact() {
        testIntegerArgBinding(MathBindings::incrementExact, Math::incrementExact, -10, -1, 0, 1, 10);
        testLongArgBinding(MathBindings::incrementExact, Math::incrementExact, -10l, -1l, 0l, 1l, 10l);
    }

    @Test
    public void testLog() {
        testDoubleArgBinding(MathBindings::log, Math::log, -12.3, -1d, 0d, 1d, 12.3, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testLog10() {
        testDoubleArgBinding(MathBindings::log10, Math::log10, -12.3, -1d, 0d, 1d, 12.3, 100d, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testLog1p() {
        testDoubleArgBinding(MathBindings::log1p, Math::log1p, -12.3, -1d, 0d, 1d, 12.3, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }


    @Test
    public void testMax() {
        testIntegerBinding2Args1(MathBindings::max, Math::max, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args2(MathBindings::max, Math::max, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args3(MathBindings::max, Math::max, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));

        testLongBinding2Args1(MathBindings::max, Math::max, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args2(MathBindings::max, Math::max, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args3(MathBindings::max, Math::max, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));

        testDoubleBinding2Args1(MathBindings::max, Math::max, new Args<>(4.3, 3.1), new Args<>(-4.3, 3.1), new Args<>(4.3, 4.3));
        testDoubleBinding2Args2(MathBindings::max, Math::max, new Args<>(4.3, 3.1), new Args<>(-4.3, 3.1), new Args<>(4.3, 4.3));
        testDoubleBinding2Args3(MathBindings::max, Math::max, new Args<>(4.3, 3.1), new Args<>(-4.3, 3.1), new Args<>(4.3, 4.3));

        testFloatBinding2Args1(MathBindings::max, Math::max, new Args<>(4.3f, 3.1f), new Args<>(-4.3f, 3.1f), new Args<>(4.3f, 4.3f));
        testFloatBinding2Args2(MathBindings::max, Math::max, new Args<>(4.3f, 3.1f), new Args<>(-4.3f, 3.1f), new Args<>(4.3f, 4.3f));
        testFloatBinding2Args3(MathBindings::max, Math::max, new Args<>(4.3f, 3.1f), new Args<>(-4.3f, 3.1f), new Args<>(4.3f, 4.3f));
    }

    @Test
    public void testMin() {
        testIntegerBinding2Args1(MathBindings::min, Math::min, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args2(MathBindings::min, Math::min, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));
        testIntegerBinding2Args3(MathBindings::min, Math::min, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(4, 4));

        testLongBinding2Args1(MathBindings::min, Math::min, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args2(MathBindings::min, Math::min, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));
        testLongBinding2Args3(MathBindings::min, Math::min, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(4l, 4l));

        testDoubleBinding2Args1(MathBindings::min, Math::min, new Args<>(4.3, 3.1), new Args<>(-4.3, 3.1), new Args<>(4.3, 4.3));
        testDoubleBinding2Args2(MathBindings::min, Math::min, new Args<>(4.3, 3.1), new Args<>(-4.3, 3.1), new Args<>(4.3, 4.3));
        testDoubleBinding2Args3(MathBindings::min, Math::min, new Args<>(4.3, 3.1), new Args<>(-4.3, 3.1), new Args<>(4.3, 4.3));

        testFloatBinding2Args1(MathBindings::min, Math::min, new Args<>(4.3f, 3.1f), new Args<>(-4.3f, 3.1f), new Args<>(4.3f, 4.3f));
        testFloatBinding2Args2(MathBindings::min, Math::min, new Args<>(4.3f, 3.1f), new Args<>(-4.3f, 3.1f), new Args<>(4.3f, 4.3f));
        testFloatBinding2Args3(MathBindings::min, Math::min, new Args<>(4.3f, 3.1f), new Args<>(-4.3f, 3.1f), new Args<>(4.3f, 4.3f));

    }


    @Test
    public void testMultiplyExact() {
        testIntegerBinding2Args1(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args2(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args3(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));

        testLongBinding2Args1(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args2(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args3(MathBindings::multiplyExact, Math::multiplyExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
    }


    @Test
    public void testNegateExact() {
        testIntegerArgBinding(MathBindings::negateExact, Math::negateExact, -10, -1, 0, 1, 10);
        testLongArgBinding(MathBindings::negateExact, Math::negateExact, -10l, -1l, 0l, 1l, 10l);
    }

    @Test
    public void testNextAfter() {
        testDoubleBinding2Args1(MathBindings::nextAfter, Math::nextAfter,
            new Args<>(1.2, 0.3),
            new Args<>(1.2, Double.NaN),
            new Args<>(Double.MIN_VALUE, -0.3),
            new Args<>(Double.NEGATIVE_INFINITY, -0.3),
            new Args<>(-0d, +0d));
        testDoubleBinding2Args2(MathBindings::nextAfter, Math::nextAfter,
            new Args<>(1.2, 0.3),
            new Args<>(1.2, Double.NaN),
            new Args<>(Double.MIN_VALUE, -0.3),
            new Args<>(Double.NEGATIVE_INFINITY, -0.3),
            new Args<>(-0d, +0d));
        testDoubleBinding2Args3(MathBindings::nextAfter, Math::nextAfter,
            new Args<>(1.2, 0.3),
            new Args<>(1.2, Double.NaN),
            new Args<>(Double.MIN_VALUE, -0.3),
            new Args<>(Double.NEGATIVE_INFINITY, -0.3),
            new Args<>(-0d, +0d));

        testFloatBinding2Args1(MathBindings::nextAfter, Math::nextAfter,
            new Args<>(1.2f, 0.3f),
            new Args<>(1.2f, Float.NaN),
            new Args<>(Float.MIN_VALUE, -0.3f),
            new Args<>(Float.NEGATIVE_INFINITY, -0.3f),
            new Args<>(-0f, +0f));
        testFloatBinding2Args2(MathBindings::nextAfter, Math::nextAfter,
            new Args<>(1.2f, 0.3f),
            new Args<>(1.2f, Float.NaN),
            new Args<>(Float.MIN_VALUE, -0.3f),
            new Args<>(Float.NEGATIVE_INFINITY, -0.3f),
            new Args<>(-0f, +0f));
        testFloatBinding2Args3(MathBindings::nextAfter, Math::nextAfter,
            new Args<>(1.2f, 0.3f),
            new Args<>(1.2f, Float.NaN),
            new Args<>(Float.MIN_VALUE, -0.3f),
            new Args<>(Float.NEGATIVE_INFINITY, -0.3f),
            new Args<>(-0f, +0f));
    }

    @Test
    public void testNextDown() {
        testDoubleArgBinding(MathBindings::nextDown, Math::nextDown, -12.3, -1d, 0d, 1d, 12.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        testFloatArgBinding(MathBindings::nextDown, Math::nextDown, -12.3f, -1f, 0f, 1f, 12.3f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    @Test
    public void testNextUp() {
        testDoubleArgBinding(MathBindings::nextUp, Math::nextUp, -12.3, -1d, 0d, 1d, 12.3, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        testFloatArgBinding(MathBindings::nextUp, Math::nextUp, -12.3f, -1f, 0f, 1f, 12.3f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
    }

    @Test
    public void testPow() {
        testDoubleBinding2Args1(MathBindings::pow, Math::pow,
            new Args<>(1.3, 3.2),
            new Args<>(1.3, 0d),
            new Args<>(1d, 3.2),
            new Args<>(1.3, Double.NaN),
            new Args<>(Double.NaN, 3.2),
            new Args<>(Double.NaN, 0d),
            new Args<>(1.1, Double.POSITIVE_INFINITY),
            new Args<>(1d, 2d));
        testDoubleBinding2Args2(MathBindings::pow, Math::pow,
            new Args<>(1.3, 3.2),
            new Args<>(1.3, 0d),
            new Args<>(1d, 3.2),
            new Args<>(1.3, Double.NaN),
            new Args<>(Double.NaN, 3.2),
            new Args<>(Double.NaN, 0d),
            new Args<>(1.1, Double.POSITIVE_INFINITY),
            new Args<>(1d, 2d));
        testDoubleBinding2Args3(MathBindings::pow, Math::pow,
            new Args<>(1.3, 3.2),
            new Args<>(1.3, 0d),
            new Args<>(1d, 3.2),
            new Args<>(1.3, Double.NaN),
            new Args<>(Double.NaN, 3.2),
            new Args<>(Double.NaN, 0d),
            new Args<>(1.1, Double.POSITIVE_INFINITY),
            new Args<>(1d, 2d));
    }

    @Test
    public void testRint() {
        testDoubleArgBinding(MathBindings::rint, Math::rint, -1d, 0d, 1d, 1.12, 1.89, 1.5, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testRound() {
        testDoubleArgBinding(MathBindings::round, Math::round, 1.34, 1.89, -12.34, -32.9, Double.NaN, 0d);
        testFloatArgBinding(MathBindings::round, Math::round, 1.34f, 1.89f, -12.34f, -32.9f, Float.NaN, 0f);
    }

    @Test
    public void testSignum() {
        testDoubleArgBinding(MathBindings::signum, Math::signum, -1d, -1.23, -0.23, 0d, 0.23, -1.23, 1d, Double.NaN);
        testFloatArgBinding(MathBindings::signum, Math::signum, -1f, -1.23f, -0.23f, 0f, 0.23f, -1.23f, 1f, Float.NaN);
    }


    @Test
    public void testSin() {
        testDoubleArgBinding(MathBindings::sin, Math::sin, -1d, 0d, 1d, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testSinh() {
        testDoubleArgBinding(MathBindings::sinh, Math::sinh, -1d, 0d, 1d, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testSqrt() {
        testDoubleArgBinding(MathBindings::sqrt, Math::sqrt, -12d, -10.34, -1d, 0d, 1d, 10.34, 12d, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testSubtractExact() {
        testIntegerBinding2Args1(MathBindings::subtractExact, Math::subtractExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args2(MathBindings::subtractExact, Math::subtractExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));
        testIntegerBinding2Args3(MathBindings::subtractExact, Math::subtractExact, new Args<>(4, 3), new Args<>(-4, 3), new Args<>(0, 4));

        testLongBinding2Args1(MathBindings::subtractExact, Math::subtractExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args2(MathBindings::subtractExact, Math::subtractExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
        testLongBinding2Args3(MathBindings::subtractExact, Math::subtractExact, new Args<>(4l, 3l), new Args<>(-4l, 3l), new Args<>(0l, 4l));
    }

    @Test
    public void testTan() {
        testDoubleArgBinding(MathBindings::tan, Math::tan, -1d, 0d, 1d, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testTanh() {
        testDoubleArgBinding(MathBindings::tanh, Math::tanh, -1d, 0d, 1d, Math.PI, -Math.PI, Double.NaN);
    }

    @Test
    public void testToDegrees() {
        testDoubleArgBinding(MathBindings::toDegrees, Math::toDegrees, -1d, 0d, 1d, 90d, -90d, 180d, 360d, 359d, Double.NaN);
    }

    @Test
    public void testToIntExact() {
        testLongArgBinding(MathBindings::toIntExact, Math::toIntExact, -1l, 0l, 302l);
    }

    @Test
    public void testToRadians() {
        testDoubleArgBinding(MathBindings::toRadians, Math::toRadians, -1d, 0d, 1d, Math.PI, 2 * Math.PI, Double.NaN);
    }

    @Test
    public void testUlp() {
        testDoubleArgBinding(MathBindings::ulp, Math::ulp, 0d, 1d, 102.3, -102.3, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        testFloatArgBinding(MathBindings::ulp, Math::ulp, 0f, 1f, 102.3f, -102.3f, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }

}
