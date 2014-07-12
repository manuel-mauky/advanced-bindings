package eu.lestard.advanced_bindings.api;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;

import static javafx.beans.binding.Bindings.*;


/**
 * This class contains binding implementations for all methods of {@link java.lang.Math}.
 *
 * @author manuel mauky
 */
public class MathBindings {

    /**
     * Binding for {@link java.lang.Math#abs(int)}
     *
     * @param   a   the argument whose absolute value is to be determined
     * @return  the absolute value of the argument.
     */
    public static IntegerBinding abs(final ObservableIntegerValue a) {
        return createIntegerBinding(() -> Math.abs(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#abs(double)}
     *
     * @param   a   the argument whose absolute value is to be determined
     * @return  the absolute value of the argument.
     */
    public static DoubleBinding abs(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.abs(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#abs(long)}
     *
     *  @param   a   the argument whose absolute value is to be determined as observableValue
     * @return  the absolute value of the argument.
     */
    public static LongBinding abs(final ObservableLongValue a) {
        return createLongBinding(() -> Math.abs(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#abs(float)}
     *
     *  @param   a   the argument whose absolute value is to be determined as observableValue
     * @return  the absolute value of the argument.
     */
    public static FloatBinding abs(final ObservableFloatValue a) {
        return createFloatBinding(() -> Math.abs(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#addExact(int, int)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding addExact(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.addExact(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#addExact(int, int)}
     *
     *  @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding addExact(final int x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.addExact(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#addExact(int, int)}
     *
     *  @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding addExact(final ObservableIntegerValue x, final int y) {
        return createIntegerBinding(() -> Math.addExact(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#addExact(long, long)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     *
     */
    public static LongBinding addExact(final ObservableLongValue x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.addExact(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#addExact(long, long)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding addExact(final long x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.addExact(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#addExact(long, long)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding addExact(final ObservableLongValue x, final long y) {
        return createLongBinding(() -> Math.addExact(x.get(), y), x);
    }

    /**
     * Binding for {@link java.lang.Math#acos(double)}
     *
     * @param   a   the value whose arc cosine is to be returned.
     * @return  the arc cosine of the argument.
     */
    public static DoubleBinding acos(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.acos(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#asin(double)}
     *
     *  @param   a   the value whose arc sine is to be returned.
     * @return  the arc sine of the argument.
     */
    public static DoubleBinding asin(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.asin(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#atan(double)}
     *
     *  @param   a   the value whose arc tangent is to be returned.
     * @return  the arc tangent of the argument.
     */
    public static DoubleBinding atan(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.atan(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#atan2(double, double)}
     *
     * @param   y   the ordinate coordinate
     * @param   x   the abscissa coordinate
     * @return  the <i>theta</i> component of the point
     *          (<i>r</i>,&nbsp;<i>theta</i>)
     *          in polar coordinates that corresponds to the point
     *          (<i>x</i>,&nbsp;<i>y</i>) in Cartesian coordinates.
     */
    public static DoubleBinding atan2(final ObservableDoubleValue y, final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.atan2(y.get(), x.get()), y, x);
    }

    /**
     * Binding for {@link java.lang.Math#atan2(double, double)}
     *
     * @param   y   the ordinate coordinate
     * @param   x   the abscissa coordinate
     * @return  the <i>theta</i> component of the point
     *          (<i>r</i>,&nbsp;<i>theta</i>)
     *          in polar coordinates that corresponds to the point
     *          (<i>x</i>,&nbsp;<i>y</i>) in Cartesian coordinates.
     */
    public static DoubleBinding atan2(final double y, final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.atan2(y, x.get()), x);
    }

    /**
     * Binding for {@link java.lang.Math#atan2(double, double)}
     *
     * @param   y   the ordinate coordinate
     * @param   x   the abscissa coordinate
     * @return  the <i>theta</i> component of the point
     *          (<i>r</i>,&nbsp;<i>theta</i>)
     *          in polar coordinates that corresponds to the point
     *          (<i>x</i>,&nbsp;<i>y</i>) in Cartesian coordinates.
     */
    public static DoubleBinding atan2(final ObservableDoubleValue y, final double x) {
        return createDoubleBinding(() -> Math.atan2(y.get(), x), y);
    }

    /**
     * Binding for {@link java.lang.Math#cbrt(double)}
     *
     * @param   a   a value.
     * @return  the cube root of {@code a}.
     */
    public static DoubleBinding cbrt(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.cbrt(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#ceil(double)}
     *
     * @param   a   a value.
     * @return  the smallest (closest to negative infinity)
     *          floating-point value that is greater than or equal to
     *          the argument and is equal to a mathematical integer.
     */
    public static DoubleBinding ceil(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.ceil(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#copySign(double, double)}
     *
     * @param magnitude  the parameter providing the magnitude of the result
     * @param sign   the parameter providing the sign of the result
     * @return a value with the magnitude of {@code magnitude}
     * and the sign of {@code sign}.
     */
    public static DoubleBinding copySign(final ObservableDoubleValue magnitude, ObservableDoubleValue sign) {
        return createDoubleBinding(() -> Math.copySign(magnitude.get(), sign.get()), magnitude, sign);
    }

    /**
     * Binding for {@link java.lang.Math#copySign(double, double)}
     *
     * @param magnitude  the parameter providing the magnitude of the result
     * @param sign   the parameter providing the sign of the result
     * @return a value with the magnitude of {@code magnitude}
     * and the sign of {@code sign}.
     */
    public static DoubleBinding copySign(final double magnitude, ObservableDoubleValue sign) {
        return createDoubleBinding(() -> Math.copySign(magnitude, sign.get()), sign);
    }

    /**
     * Binding for {@link java.lang.Math#copySign(double, double)}
     *
     * @param magnitude  the parameter providing the magnitude of the result
     * @param sign   the parameter providing the sign of the result
     * @return a value with the magnitude of {@code magnitude}
     * and the sign of {@code sign}.
     */
    public static DoubleBinding copySign(final ObservableDoubleValue magnitude, double sign) {
        return createDoubleBinding(() -> Math.copySign(magnitude.get(), sign), magnitude);
    }


    /**
     * Binding for {@link java.lang.Math#copySign(float, float)}
     *
     * @param magnitude  the parameter providing the magnitude of the result
     * @param sign   the parameter providing the sign of the result
     * @return a value with the magnitude of {@code magnitude}
     * and the sign of {@code sign}.
     */
    public static FloatBinding copySign(final ObservableFloatValue magnitude, ObservableFloatValue sign) {
        return createFloatBinding(() -> Math.copySign(magnitude.get(), sign.get()), magnitude, sign);
    }

    /**
     * Binding for {@link java.lang.Math#copySign(float, float)}
     *
     * @param magnitude  the parameter providing the magnitude of the result
     * @param sign   the parameter providing the sign of the result
     * @return a value with the magnitude of {@code magnitude}
     * and the sign of {@code sign}.
     */
    public static FloatBinding copySign(final float magnitude, ObservableFloatValue sign) {
        return createFloatBinding(() -> Math.copySign(magnitude, sign.get()), sign);
    }

    /**
     * Binding for {@link java.lang.Math#copySign(float, float)}
     *
     * @param magnitude  the parameter providing the magnitude of the result
     * @param sign   the parameter providing the sign of the result
     * @return a value with the magnitude of {@code magnitude}
     * and the sign of {@code sign}.
     */
    public static FloatBinding copySign(final ObservableFloatValue magnitude, float sign) {
        return createFloatBinding(() -> Math.copySign(magnitude.get(), sign), magnitude);
    }

    /**
     * Binding for {@link java.lang.Math#cos(double)}
     *
     * @param   a   an angle, in radians.
     * @return  the cosine of the argument.
     */
    public static DoubleBinding cos(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.cos(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#cosh(double)}
     *
     * @param   x The number whose hyperbolic cosine is to be returned.
     * @return  The hyperbolic cosine of {@code x}.
     */
    public static DoubleBinding cosh(final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.cosh(x.get()), x);
    }

    /**
     * Binding for {@link java.lang.Math#decrementExact(int)}
     *
     *  @param a the value to decrement
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding decrementExact(final ObservableIntegerValue a) {
        return createIntegerBinding(() -> Math.decrementExact(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#decrementExact(long)}
     *
     * @param a the value to decrement
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding decrementExact(final ObservableLongValue a) {
        return createLongBinding(() -> Math.decrementExact(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#exp(double)}
     *
     * @param   a   the exponent to raise <i>e</i> to.
     * @return  the value <i>e</i><sup>{@code a}</sup>,
     *          where <i>e</i> is the base of the natural logarithms.
     */
    public static DoubleBinding exp(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.exp(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#expm1(double)}
     *
     * @param   x   the exponent to raise <i>e</i> to in the computation of
     *              <i>e</i><sup>{@code x}</sup>&nbsp;-1.
     * @return  the value <i>e</i><sup>{@code x}</sup>&nbsp;-&nbsp;1.
     */
    public static DoubleBinding expm1(final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.expm1(x.get()), x);
    }

    /**
     * Binding for {@link java.lang.Math#floor(double)}
     *
     * @param   a   a value.
     * @return  the largest (closest to positive infinity)
     *          floating-point value that less than or equal to the argument
     *          and is equal to a mathematical integer.
     */
    public static DoubleBinding floor(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.floor(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#floorDiv(int, int)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity)
     * {@code int} value that is less than or equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static IntegerBinding floorDiv(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.floorDiv(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#floorDiv(int, int)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity)
     * {@code int} value that is less than or equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static IntegerBinding floorDiv(final int x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.floorDiv(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#floorDiv(int, int)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity)
     * {@code int} value that is less than or equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static IntegerBinding floorDiv(final ObservableIntegerValue x, final int y) {
        return createIntegerBinding(() -> Math.floorDiv(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#floorDiv(long, long)}
     *
     *  @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity)
     * {@code long} value that is less than or equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static LongBinding floorDiv(final ObservableLongValue x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.floorDiv(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#floorDiv(long, long)}
     *
     *  @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity)
     * {@code long} value that is less than or equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static LongBinding floorDiv(final long x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.floorDiv(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#floorDiv(long, long)}
     *
     *  @param x the dividend
     * @param y the divisor
     * @return the largest (closest to positive infinity)
     * {@code long} value that is less than or equal to the algebraic quotient.
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static LongBinding floorDiv(final ObservableLongValue x, final long y) {
        return createLongBinding(() -> Math.floorDiv(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#floorMod(int, int)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static IntegerBinding floorMod(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.floorMod(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#floorMod(int, int)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static IntegerBinding floorMod(final int x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.floorMod(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#floorMod(int, int)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static IntegerBinding floorMod(final ObservableIntegerValue x, final int y) {
        return createIntegerBinding(() -> Math.floorMod(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#floorMod(long, long)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static LongBinding floorMod(final ObservableLongValue x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.floorMod(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#floorMod(long, long)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static LongBinding floorMod(final long x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.floorMod(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#floorMod(long, long)}
     *
     * @param x the dividend
     * @param y the divisor
     * @return the floor modulus {@code x - (floorDiv(x, y) * y)}
     * @throws ArithmeticException if the divisor {@code y} is zero
     */
    public static LongBinding floorMod(final ObservableLongValue x, final long y) {
        return createLongBinding(() -> Math.floorMod(x.get(), y), x);
    }

    /**
     * Binding for {@link java.lang.Math#getExponent(double)}
     *
     * @param d a {@code double} value
     * @return the unbiased exponent of the argument
     */
    public static IntegerBinding getExponent(final ObservableDoubleValue d) {
        return createIntegerBinding(() -> Math.getExponent(d.get()), d);
    }

    /**
     * Binding for {@link java.lang.Math#getExponent(float)}
     *
     * @param f a {@code float} value
     * @return the unbiased exponent of the argument
     */
    public static IntegerBinding getExponent(final ObservableFloatValue f) {
        return createIntegerBinding(() -> Math.getExponent(f.get()), f);
    }


    /**
     * Binding for {@link java.lang.Math#hypot(double, double)}
     *
     * @param x a value
     * @param y a value
     * @return sqrt(<i>x</i><sup>2</sup>&nbsp;+<i>y</i><sup>2</sup>)
     * without intermediate overflow or underflow
     */
    public static DoubleBinding hypot(final ObservableDoubleValue x, final ObservableDoubleValue y) {
        return createDoubleBinding(() -> Math.hypot(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#hypot(double, double)}
     *
     * @param x a value
     * @param y a value
     * @return sqrt(<i>x</i><sup>2</sup>&nbsp;+<i>y</i><sup>2</sup>)
     * without intermediate overflow or underflow
     */
    public static DoubleBinding hypot(final double x, final ObservableDoubleValue y) {
        return createDoubleBinding(() -> Math.hypot(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#hypot(double, double)}
     *
     * @param x a value
     * @param y a value
     * @return sqrt(<i>x</i><sup>2</sup>&nbsp;+<i>y</i><sup>2</sup>)
     * without intermediate overflow or underflow
     */
    public static DoubleBinding hypot(final ObservableDoubleValue x, final double y) {
        return createDoubleBinding(() -> Math.hypot(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#IEEEremainder(double, double)}
     *
     *  @param   f1   the dividend.
     * @param   f2   the divisor.
     * @return  the remainder when {@code f1} is divided by
     *          {@code f2}.
     */
    public static DoubleBinding IEEEremainder(final ObservableDoubleValue f1, final ObservableDoubleValue f2) {
        return createDoubleBinding(() -> Math.IEEEremainder(f1.get(), f2.get()), f1, f2);
    }

    /**
     * Binding for {@link java.lang.Math#IEEEremainder(double, double)}
     *
     *  @param   f1   the dividend.
     * @param   f2   the divisor.
     * @return  the remainder when {@code f1} is divided by
     *          {@code f2}.
     */
    public static DoubleBinding IEEEremainder(final double f1, final ObservableDoubleValue f2) {
        return createDoubleBinding(() -> Math.IEEEremainder(f1, f2.get()), f2);
    }

    /**
     * Binding for {@link java.lang.Math#IEEEremainder(double, double)}
     *
     *  @param   f1   the dividend.
     * @param   f2   the divisor.
     * @return  the remainder when {@code f1} is divided by
     *          {@code f2}.
     */
    public static DoubleBinding IEEEremainder(final ObservableDoubleValue f1, final double f2) {
        return createDoubleBinding(() -> Math.IEEEremainder(f1.get(), f2), f1);
    }


    /**
     * Binding for {@link java.lang.Math#incrementExact(int)}
     *
     * @param a the value to increment
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding incrementExact(final ObservableIntegerValue a) {
        return createIntegerBinding(() -> Math.incrementExact(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#incrementExact(long)}
     *
     *  @param a the value to increment
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding incrementExact(final ObservableLongValue a) {
        return createLongBinding(() -> Math.incrementExact(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#log(double)}
     *
     * @param   a   a value
     * @return  the value ln&nbsp;{@code a}, the natural logarithm of
     *          {@code a}.
     */
    public static DoubleBinding log(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.log(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#log10(double)}
     *
     *  @param   a   a value
     * @return  the base 10 logarithm of  {@code a}.
     */
    public static DoubleBinding log10(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.log10(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#log1p(double)}
     *
     * @param   x   a value
     * @return the value ln({@code x}&nbsp;+&nbsp;1), the natural
     * log of {@code x}&nbsp;+&nbsp;1
     */
    public static DoubleBinding log1p(final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.log1p(x.get()), x);
    }


    /**
     * Binding for {@link java.lang.Math#max(double, double)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static DoubleBinding max(final ObservableDoubleValue a, final ObservableDoubleValue b) {
        return createDoubleBinding(() -> Math.max(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#max(double, double)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static DoubleBinding max(final double a, final ObservableDoubleValue b) {
        return createDoubleBinding(() -> Math.max(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#max(double, double)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static DoubleBinding max(final ObservableDoubleValue a, final double b) {
        return createDoubleBinding(() -> Math.max(a.get(), b), a);
    }


    /**
     * Binding for {@link java.lang.Math#max(float, float)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static FloatBinding max(final ObservableFloatValue a, final ObservableFloatValue b) {
        return createFloatBinding(() -> Math.max(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#max(float, float)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static FloatBinding max(final float a, final ObservableFloatValue b) {
        return createFloatBinding(() -> Math.max(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#max(float, float)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static FloatBinding max(final ObservableFloatValue a, final float b) {
        return createFloatBinding(() -> Math.max(a.get(), b), a);
    }


    /**
     * Binding for {@link java.lang.Math#max(int, int)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static IntegerBinding max(final ObservableIntegerValue a, final ObservableIntegerValue b) {
        return createIntegerBinding(() -> Math.max(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#max(int, int)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static IntegerBinding max(final int a, final ObservableIntegerValue b) {
        return createIntegerBinding(() -> Math.max(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#max(int, int)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static IntegerBinding max(final ObservableIntegerValue a, final int b) {
        return createIntegerBinding(() -> Math.max(a.get(), b), a);
    }

    /**
     * Binding for {@link java.lang.Math#max(long, long)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static LongBinding max(final ObservableLongValue a, final ObservableLongValue b) {
        return createLongBinding(() -> Math.max(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#max(long, long)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static LongBinding max(final long a, final ObservableLongValue b) {
        return createLongBinding(() -> Math.max(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#max(long, long)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the larger of {@code a} and {@code b}.
     */
    public static LongBinding max(final ObservableLongValue a, final long b) {
        return createLongBinding(() -> Math.max(a.get(), b), a);
    }


    /**
     * Binding for {@link java.lang.Math#min(double, double)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static DoubleBinding min(final ObservableDoubleValue a, final ObservableDoubleValue b) {
        return createDoubleBinding(() -> Math.min(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#min(double, double)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static DoubleBinding min(final double a, final ObservableDoubleValue b) {
        return createDoubleBinding(() -> Math.min(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#min(double, double)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static DoubleBinding min(final ObservableDoubleValue a, final double b) {
        return createDoubleBinding(() -> Math.min(a.get(), b), a);
    }


    /**
     * Binding for {@link java.lang.Math#min(float, float)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static FloatBinding min(final ObservableFloatValue a, final ObservableFloatValue b) {
        return createFloatBinding(() -> Math.min(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#min(float, float)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static FloatBinding min(final float a, final ObservableFloatValue b) {
        return createFloatBinding(() -> Math.min(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#min(float, float)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static FloatBinding min(final ObservableFloatValue a, final float b) {
        return createFloatBinding(() -> Math.min(a.get(), b), a);
    }


    /**
     * Binding for {@link java.lang.Math#min(int, int)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static IntegerBinding min(final ObservableIntegerValue a, final ObservableIntegerValue b) {
        return createIntegerBinding(() -> Math.min(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#min(int, int)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static IntegerBinding min(final int a, final ObservableIntegerValue b) {
        return createIntegerBinding(() -> Math.min(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#min(int, int)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static IntegerBinding min(final ObservableIntegerValue a, final int b) {
        return createIntegerBinding(() -> Math.min(a.get(), b), a);
    }

    /**
     * Binding for {@link java.lang.Math#min(long, long)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static LongBinding min(final ObservableLongValue a, final ObservableLongValue b) {
        return createLongBinding(() -> Math.min(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#min(long, long)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static LongBinding min(final long a, final ObservableLongValue b) {
        return createLongBinding(() -> Math.min(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#min(long, long)}
     *
     * @param   a   an argument.
     * @param   b   another argument.
     * @return  the smaller of {@code a} and {@code b}.
     */
    public static LongBinding min(final ObservableLongValue a, final long b) {
        return createLongBinding(() -> Math.min(a.get(), b), a);
    }


    /**
     * Binding for {@link java.lang.Math#multiplyExact(int, int)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding multiplyExact(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.multiplyExact(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#multiplyExact(int, int)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding multiplyExact(final int x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.multiplyExact(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#multiplyExact(int, int)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding multiplyExact(final ObservableIntegerValue x, final int y) {
        return createIntegerBinding(() -> Math.multiplyExact(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#multiplyExact(long, long)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding multiplyExact(final ObservableLongValue x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.multiplyExact(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#multiplyExact(long, long)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding multiplyExact(final long x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.multiplyExact(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#multiplyExact(long, long)}
     *
     * @param x the first value
     * @param y the second value
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding multiplyExact(final ObservableLongValue x, final long y) {
        return createLongBinding(() -> Math.multiplyExact(x.get(), y), x);
    }

    /**
     * Binding for {@link java.lang.Math#negateExact(int)}
     *
     *  @param a the value to negate
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding negateExact(final ObservableIntegerValue a) {
        return createIntegerBinding(() -> Math.negateExact(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#negateExact(long)}
     *
     * @param a the value to negate
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding negateExact(final ObservableLongValue a) {
        return createLongBinding(() -> Math.negateExact(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#nextAfter(double, double)}
     *
     *  @param start  starting floating-point value
     * @param direction value indicating which of
     * {@code start}'s neighbors or {@code start} should
     * be returned
     * @return The floating-point number adjacent to {@code start} in the
     * direction of {@code direction}.
     */
    public static DoubleBinding nextAfter(final ObservableDoubleValue start, final ObservableDoubleValue direction) {
        return createDoubleBinding(() -> Math.nextAfter(start.get(), direction.get()), start, direction);
    }

    /**
     * Binding for {@link java.lang.Math#nextAfter(double, double)}
     *
     *  @param start  starting floating-point value
     * @param direction value indicating which of
     * {@code start}'s neighbors or {@code start} should
     * be returned
     * @return The floating-point number adjacent to {@code start} in the
     * direction of {@code direction}.
     */
    public static DoubleBinding nextAfter(final double start, final ObservableDoubleValue direction) {
        return createDoubleBinding(() -> Math.nextAfter(start, direction.get()), direction);
    }

    /**
     * Binding for {@link java.lang.Math#nextAfter(double, double)}
     *
     *  @param start  starting floating-point value
     * @param direction value indicating which of
     * {@code start}'s neighbors or {@code start} should
     * be returned
     * @return The floating-point number adjacent to {@code start} in the
     * direction of {@code direction}.
     */
    public static DoubleBinding nextAfter(final ObservableDoubleValue start, final double direction) {
        return createDoubleBinding(() -> Math.nextAfter(start.get(), direction), start);
    }


    /**
     * Binding for {@link java.lang.Math#nextAfter(float, double)}
     *
     * @param start  starting floating-point value
     * @param direction value indicating which of
     * {@code start}'s neighbors or {@code start} should
     * be returned
     * @return The floating-point number adjacent to {@code start} in the
     * direction of {@code direction}.
     */
    public static FloatBinding nextAfter(final ObservableFloatValue start, final ObservableFloatValue direction) {
        return createFloatBinding(() -> Math.nextAfter(start.get(), direction.get()), start, direction);
    }

    /**
     * Binding for {@link java.lang.Math#nextAfter(float, double)}
     *
     * @param start  starting floating-point value
     * @param direction value indicating which of
     * {@code start}'s neighbors or {@code start} should
     * be returned
     * @return The floating-point number adjacent to {@code start} in the
     * direction of {@code direction}.
     */
    public static FloatBinding nextAfter(final float start, final ObservableFloatValue direction) {
        return createFloatBinding(() -> Math.nextAfter(start, direction.get()), direction);
    }

    /**
     * Binding for {@link java.lang.Math#nextAfter(float, double)}
     *
     * @param start  starting floating-point value
     * @param direction value indicating which of
     * {@code start}'s neighbors or {@code start} should
     * be returned
     * @return The floating-point number adjacent to {@code start} in the
     * direction of {@code direction}.
     */
    public static FloatBinding nextAfter(final ObservableFloatValue start, final float direction) {
        return createFloatBinding(() -> Math.nextAfter(start.get(), direction), start);
    }


    /**
     * Binding for {@link java.lang.Math#nextDown(double)}
     *
     * @param d  starting floating-point value
     * @return The adjacent floating-point value closer to negative
     * infinity.
     */
    public static DoubleBinding nextDown(final ObservableDoubleValue d) {
        return createDoubleBinding(() -> Math.nextDown(d.get()), d);
    }

    /**
     * Binding for {@link java.lang.Math#nextDown(float)}
     *
     * @param f  starting floating-point value
     * @return The adjacent floating-point value closer to negative
     * infinity.
     */
    public static FloatBinding nextDown(final ObservableFloatValue f) {
        return createFloatBinding(() -> Math.nextDown(f.get()), f);
    }

    /**
     * Binding for {@link java.lang.Math#nextUp(double)}
     *
     * @param d starting floating-point value
     * @return The adjacent floating-point value closer to positive
     * infinity.
     */
    public static DoubleBinding nextUp(final ObservableDoubleValue d) {
        return createDoubleBinding(() -> Math.nextUp(d.get()), d);
    }

    /**
     * Binding for {@link java.lang.Math#nextUp(float)}
     *
     * @param f starting floating-point value
     * @return The adjacent floating-point value closer to positive
     * infinity.
     */
    public static FloatBinding nextUp(final ObservableFloatValue f) {
        return createFloatBinding(() -> Math.nextUp(f.get()), f);
    }


    /**
     * Binding for {@link java.lang.Math#pow(double, double)}
     *
     * @param   a   the base.
     * @param   b   the exponent.
     * @return  the value {@code a}<sup>{@code b}</sup>.
     */
    public static DoubleBinding pow(final ObservableDoubleValue a, final ObservableDoubleValue b) {
        return createDoubleBinding(() -> Math.pow(a.get(), b.get()), a, b);
    }

    /**
     * Binding for {@link java.lang.Math#pow(double, double)}
     *
     * @param   a   the base.
     * @param   b   the exponent.
     * @return  the value {@code a}<sup>{@code b}</sup>.
     */
    public static DoubleBinding pow(final double a, final ObservableDoubleValue b) {
        return createDoubleBinding(() -> Math.pow(a, b.get()), b);
    }

    /**
     * Binding for {@link java.lang.Math#pow(double, double)}
     *
     * @param   a   the base.
     * @param   b   the exponent.
     * @return  the value {@code a}<sup>{@code b}</sup>.
     */
    public static DoubleBinding pow(final ObservableDoubleValue a, final double b) {
        return createDoubleBinding(() -> Math.pow(a.get(), b), a);
    }

    /**
     * Binding for {@link java.lang.Math#rint(double)}
     *
     * @param   a   a {@code double} value.
     * @return  the closest floating-point value to {@code a} that is
     *          equal to a mathematical integer.
     */
    public static DoubleBinding rint(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.rint(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#round(double)}
     *
     * @param   a   a floating-point value to be rounded to a
     *          {@code long}.
     * @return  the value of the argument rounded to the nearest
     *          {@code long} value.
     */
    public static LongBinding round(final ObservableDoubleValue a) {
        return createLongBinding(() -> Math.round(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#round(float)}
     *
     * @param   a   a floating-point value to be rounded to an integer.
     * @return  the value of the argument rounded to the nearest
     *          {@code int} value.
     */
    public static IntegerBinding round(final ObservableFloatValue a) {
        return createIntegerBinding(() -> Math.round(a.get()), a);
    }

    /**
     * Binding for {@link java.lang.Math#scalb(double, int)}
     *
     * @param d number to be scaled by a power of two.
     * @param scaleFactor power of 2 used to scale {@code d}
     * @return {@code d} &times; 2<sup>{@code scaleFactor}</sup>
     */
    public static DoubleBinding scalb(final ObservableDoubleValue d, final ObservableIntegerValue scaleFactor) {
        return createDoubleBinding(()->Math.scalb(d.get(), scaleFactor.get()), d, scaleFactor);
    }

    /**
     * Binding for {@link java.lang.Math#scalb(double, int)}
     *
     * @param d number to be scaled by a power of two.
     * @param scaleFactor power of 2 used to scale {@code d}
     * @return {@code d} &times; 2<sup>{@code scaleFactor}</sup>
     */
    public static DoubleBinding scalb(final double d, final ObservableIntegerValue scaleFactor) {
        return createDoubleBinding(()->Math.scalb(d, scaleFactor.get()), scaleFactor);
    }

    /**
     * Binding for {@link java.lang.Math#scalb(double, int)}
     *
     * @param d number to be scaled by a power of two.
     * @param scaleFactor power of 2 used to scale {@code d}
     * @return {@code d} &times; 2<sup>{@code scaleFactor}</sup>
     */
    public static DoubleBinding scalb(final ObservableDoubleValue d, final int scaleFactor) {
        return createDoubleBinding(()->Math.scalb(d.get(), scaleFactor), d);
    }


    /**
     * Binding for {@link java.lang.Math#scalb(float, int)}
     *
     * @param f number to be scaled by a power of two.
     * @param scaleFactor power of 2 used to scale {@code f}
     * @return {@code f} &times; 2<sup>{@code scaleFactor}</sup>
     */
    public static FloatBinding scalb(final ObservableFloatValue f, final ObservableIntegerValue scaleFactor) {
        return createFloatBinding(()->Math.scalb(f.get(), scaleFactor.get()),f, scaleFactor);
    }

    /**
     * Binding for {@link java.lang.Math#scalb(float, int)}
     *
     * @param f number to be scaled by a power of two.
     * @param scaleFactor power of 2 used to scale {@code f}
     * @return {@code f} &times; 2<sup>{@code scaleFactor}</sup>
     */
    public static FloatBinding scalb(final float f, final ObservableIntegerValue scaleFactor) {
        return createFloatBinding(()->Math.scalb(f, scaleFactor.get()), scaleFactor);
    }

    /**
     * Binding for {@link java.lang.Math#scalb(float, int)}
     *
     * @param f number to be scaled by a power of two.
     * @param scaleFactor power of 2 used to scale {@code f}
     * @return {@code f} &times; 2<sup>{@code scaleFactor}</sup>
     */
    public static FloatBinding scalb(final ObservableFloatValue f, final int scaleFactor) {
        return createFloatBinding(()->Math.scalb(f.get(), scaleFactor),f);
    }


    /**
     * Binding for {@link java.lang.Math#signum(double)}
     *
     * @param d the floating-point value whose signum is to be returned
     * @return the signum function of the argument
     */
    public static DoubleBinding signum(final ObservableDoubleValue d) {
        return createDoubleBinding(() -> Math.signum(d.get()), d);
    }

    /**
     * Binding for {@link java.lang.Math#signum(float)}
     *
     * @param f the floating-point value whose signum is to be returned
     * @return the signum function of the argument
     */
    public static FloatBinding signum(final ObservableFloatValue f) {
        return createFloatBinding(() -> Math.signum(f.get()), f);
    }


    /**
     * Binding for {@link java.lang.Math#sin(double)}
     *
     * @param   a   an angle, in radians.
     * @return  the sine of the argument.
     */
    public static DoubleBinding sin(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.sin(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#sinh(double)}
     *
     * @param   x The number whose hyperbolic sine is to be returned.
     * @return  The hyperbolic sine of {@code x}.
     */
    public static DoubleBinding sinh(final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.sinh(x.get()), x);
    }


    /**
     * Binding for {@link java.lang.Math#sqrt(double)}
     *
     * @param   a   a value.
     * @return  the positive square root of {@code a}.
     *          If the argument is NaN or less than zero, the result is NaN.
     */
    public static DoubleBinding sqrt(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.sqrt(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#subtractExact(int, int)}
     *
     *  @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding subtractExact(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.subtractExact(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#subtractExact(int, int)}
     *
     *  @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding subtractExact(final int x, final ObservableIntegerValue y) {
        return createIntegerBinding(() -> Math.subtractExact(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#subtractExact(int, int)}
     *
     *  @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows an int
     */
    public static IntegerBinding subtractExact(final ObservableIntegerValue x, final int y) {
        return createIntegerBinding(() -> Math.subtractExact(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#subtractExact(long, long)}
     *
     *  @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding subtractExact(final ObservableLongValue x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.subtractExact(x.get(), y.get()), x, y);
    }

    /**
     * Binding for {@link java.lang.Math#subtractExact(long, long)}
     *
     *  @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding subtractExact(final long x, final ObservableLongValue y) {
        return createLongBinding(() -> Math.subtractExact(x, y.get()), y);
    }

    /**
     * Binding for {@link java.lang.Math#subtractExact(long, long)}
     *
     *  @param x the first value
     * @param y the second value to subtract from the first
     * @return the result
     * @throws ArithmeticException if the result overflows a long
     */
    public static LongBinding subtractExact(final ObservableLongValue x, final long y) {
        return createLongBinding(() -> Math.subtractExact(x.get(), y), x);
    }


    /**
     * Binding for {@link java.lang.Math#tan(double)}
     *
     * @param   a   an angle, in radians.
     * @return  the tangent of the argument.
     */
    public static DoubleBinding tan(final ObservableDoubleValue a) {
        return createDoubleBinding(() -> Math.tan(a.get()), a);
    }


    /**
     * Binding for {@link java.lang.Math#tanh(double)}
     *
     * @param   x The number whose hyperbolic tangent is to be returned.
     * @return  The hyperbolic tangent of {@code x}.
     */
    public static DoubleBinding tanh(final ObservableDoubleValue x) {
        return createDoubleBinding(() -> Math.tanh(x.get()), x);
    }


    /**
     * Binding for {@link java.lang.Math#toDegrees(double)}
     *
     * @param   angrad   an angle, in radians
     * @return  the measurement of the angle {@code angrad}
     *          in degrees.
     */
    public static DoubleBinding toDegrees(final ObservableDoubleValue angrad) {
        return createDoubleBinding(() -> Math.toDegrees(angrad.get()), angrad);
    }


    /**
     * Binding for {@link java.lang.Math#toIntExact(long)}
     *
     * @param value the long value
     * @return the argument as an int
     * @throws ArithmeticException if the {@code argument} overflows an int
     */
    public static IntegerBinding toIntExact(final ObservableLongValue value) {
        return createIntegerBinding(() -> Math.toIntExact(value.get()), value);
    }


    /**
     * Binding for {@link java.lang.Math#toRadians(double)}
     *
     *  @param   angdeg   an angle, in degrees
     * @return  the measurement of the angle {@code angdeg}
     *          in radians.
     */
    public static DoubleBinding toRadians(final ObservableDoubleValue angdeg) {
        return createDoubleBinding(() -> Math.toRadians(angdeg.get()), angdeg);
    }


    /**
     * Binding for {@link java.lang.Math#ulp(double)}
     *
     * @param d the floating-point value whose ulp is to be returned
     * @return the size of an ulp of the argument
     */
    public static DoubleBinding ulp(final ObservableDoubleValue d) {
        return createDoubleBinding(() -> Math.ulp(d.get()), d);
    }

    /**
     * Binding for {@link java.lang.Math#ulp(float)}
     *
     * @param f the floating-point value whose ulp is to be returned
     * @return the size of an ulp of the argument
     */
    public static FloatBinding ulp(final ObservableFloatValue f) {
        return createFloatBinding(() -> Math.ulp(f.get()), f);
    }

}
