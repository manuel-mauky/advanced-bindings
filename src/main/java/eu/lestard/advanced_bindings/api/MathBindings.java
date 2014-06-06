package eu.lestard.advanced_bindings.api;

import eu.lestard.advanced_bindings.api.internal.math.Abs;
import eu.lestard.advanced_bindings.api.internal.math.Acos;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.LongBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableLongValue;

public class MathBindings {

    /**
     * Binding for {@link java.lang.Math#abs(int)}
     */
    public static IntegerBinding abs(final ObservableIntegerValue a) {
        return Abs.abs(a);
    }

    /**
     * Binding for {@link java.lang.Math#abs(double)}
     */
    public static DoubleBinding abs(final ObservableDoubleValue a) {
        return Abs.abs(a);
    }

    /**
     * Binding for {@link java.lang.Math#abs(long)}
     */
    public static LongBinding abs(final ObservableLongValue a) {
        return Abs.abs(a);
    }

    /**
     * Binding for {@link java.lang.Math#abs(float)}
     */
    public static FloatBinding abs(final ObservableFloatValue a) {
        return Abs.abs(a);
    }


    /**
     * Binding for {@link java.lang.Math#addExact(int, int)}
     */
    public static IntegerBinding addExact(final ObservableIntegerValue x, final ObservableIntegerValue y){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#addExact(int, int)}
     */
    public static IntegerBinding addExact(final int x, final ObservableIntegerValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#addExact(int, int)}
     */
    public static IntegerBinding addExact(final ObservableIntegerValue x, final int y){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#addExact(long, long)}
     */
    public static LongBinding addExact(final ObservableLongValue x, final ObservableLongValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#addExact(long, long)}
     */
    public static LongBinding addExact(final long x, final ObservableLongValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#addExact(long, long)}
     */
    public static LongBinding addExact(final ObservableLongValue x, final long y){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#acos(double)}
     */
    public static DoubleBinding acos(final ObservableDoubleValue a) {
        return Acos.acos(a);
    }


    /**
     * Binding for {@link java.lang.Math#asin(double)}
     */
    public static DoubleBinding asin(final ObservableDoubleValue a) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#atan(double)}
     */
    public static DoubleBinding atan(final ObservableDoubleValue a) {
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#atan2(double, double)}
     */
    public static DoubleBinding atan2(final ObservableDoubleValue y, final ObservableDoubleValue x) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#atan2(double, double)}
     */
    public static DoubleBinding atan2(final double y, final ObservableDoubleValue x) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#atan2(double, double)}
     */
    public static DoubleBinding atan2(final ObservableDoubleValue y, final double x) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#cbrt(double)}
     */
    public static DoubleBinding cbrt(final ObservableDoubleValue a) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#ceil(double)}
     */
    public static DoubleBinding ceil(final ObservableDoubleValue a) {
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#copySign(double, double)}
     */
    public static DoubleBinding copySign(final ObservableDoubleValue magnitude, ObservableDoubleValue sign) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#copySign(double, double)}
     */
    public static DoubleBinding copySign(final double magnitude, ObservableDoubleValue sign) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#copySign(double, double)}
     */
    public static DoubleBinding copySign(final ObservableDoubleValue magnitude, double sign) {
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#copySign(float, float)}
     */
    public static FloatBinding copySign(final ObservableFloatValue magnitude, ObservableFloatValue sign) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#copySign(float, float)}
     */
    public static FloatBinding copySign(final float magnitude, ObservableFloatValue sign) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#copySign(float, float)}
     */
    public static FloatBinding copySign(final ObservableFloatValue magnitude, float sign) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#cos(double)}
     */
    public static DoubleBinding cos(final ObservableDoubleValue a) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#cosh(double)}
     */
    public static DoubleBinding cosh(final ObservableDoubleValue x) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#decrementExact(int)}
     */
    public static IntegerBinding decrementExact(final ObservableIntegerValue x) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#decrementExact(long)}
     */
    public static LongBinding decrementExact(final ObservableLongValue x) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#exp(double)}
     */
    public static DoubleBinding exp(final ObservableDoubleValue a) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#expm1(double)}
     */
    public static DoubleBinding expm1(final ObservableDoubleValue x) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#floor(double)}
     */
    public static DoubleBinding floor(final ObservableDoubleValue a) {
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#floorDiv(int, int)}
     */
    public static IntegerBinding floorDiv(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorDiv(int, int)}
     */
    public static IntegerBinding floorDiv(final int x, final ObservableIntegerValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorDiv(int, int)}
     */
    public static IntegerBinding floorDiv(final ObservableIntegerValue x, final int y) {
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#floorDiv(long, long)}
     */
    public static LongBinding floorDiv(final ObservableLongValue x, final ObservableLongValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorDiv(long, long)}
     */
    public static LongBinding floorDiv(final long x, final ObservableLongValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorDiv(long, long)}
     */
    public static LongBinding floorDiv(final ObservableLongValue x, final long y) {
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#floorMod(int, int)}
     */
    public static IntegerBinding floorMod(final ObservableIntegerValue x, final ObservableIntegerValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorMod(int, int)}
     */
    public static IntegerBinding floorMod(final int x, final ObservableIntegerValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorMod(int, int)}
     */
    public static IntegerBinding floorMod(final ObservableIntegerValue x, final int y) {
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#floorMod(long, long)}
     */
    public static LongBinding floorMod(final ObservableLongValue x, final ObservableLongValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorMod(long, long)}
     */
    public static LongBinding floorMod(final long x, final ObservableLongValue y) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#floorMod(long, long)}
     */
    public static LongBinding floorMod(final ObservableLongValue x, final long y) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#getExponent(double)}
     */
    public static IntegerBinding getExponent(final ObservableDoubleValue d){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#getExponent(float)}
     */
    public static IntegerBinding getExponent(final ObservableFloatValue f){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#hypot(double, double)}
     */
    public static DoubleBinding hypot(final ObservableDoubleValue x, final ObservableDoubleValue y) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#hypot(double, double)}
     */
    public static DoubleBinding hypot(final double x, final ObservableDoubleValue y) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#hypot(double, double)}
     */
    public static DoubleBinding hypot(final ObservableDoubleValue x, final double y) {
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#IEEEremainder(double, double)}
     */
    public static DoubleBinding IEEEremainder(final ObservableDoubleValue f1, final ObservableDoubleValue f2) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#IEEEremainder(double, double)}
     */
    public static DoubleBinding IEEEremainder(final double f1, final ObservableDoubleValue f2) {
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#IEEEremainder(double, double)}
     */
    public static DoubleBinding IEEEremainder(final ObservableDoubleValue f1, final double f2) {
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#incrementExact(long)}
     */
    public static IntegerBinding incrementExact(final ObservableIntegerValue a){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#incrementExact(long)}
     */
    public static LongBinding incrementExact(final ObservableLongValue a){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#log(double)}
     */
    public static DoubleBinding log(final ObservableDoubleValue a){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#log10(double)}
     */
    public static DoubleBinding log10(final ObservableDoubleValue a){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#log1p(double)}
     */
    public static DoubleBinding log1p(final ObservableDoubleValue x){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#max(double, double)}
     */
    public static DoubleBinding max(final ObservableDoubleValue a, final ObservableDoubleValue b) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(double, double)}
     */
    public static DoubleBinding max(final double a, final ObservableDoubleValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(double, double)}
     */
    public static DoubleBinding max(final ObservableDoubleValue a, final double b){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#max(float, float)}
     */
    public static FloatBinding max(final ObservableFloatValue a, final ObservableFloatValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(float, float)}
     */
    public static FloatBinding max(final float a, final ObservableFloatValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(float, float)}
     */
    public static FloatBinding max(final ObservableFloatValue a, final float b){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#max(int, int)}
     */
    public static IntegerBinding max(final ObservableIntegerValue a, final ObservableIntegerValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(int, int)}
     */
    public static IntegerBinding max(final int a, final ObservableIntegerValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(int, int)}
     */
    public static IntegerBinding max(final ObservableIntegerValue a, final int b){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#max(long, long)}
     */
    public static LongBinding max(final ObservableLongValue a, final ObservableLongValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(long, long)}
     */
    public static LongBinding max(final long a, final ObservableLongValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#max(long, long)}
     */
    public static LongBinding max(final ObservableLongValue a, final long b){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#min(double, double)}
     */
    public static DoubleBinding min(final ObservableDoubleValue a, final ObservableDoubleValue b) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(double, double)}
     */
    public static DoubleBinding min(final double a, final ObservableDoubleValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(double, double)}
     */
    public static DoubleBinding min(final ObservableDoubleValue a, final double b){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#min(float, float)}
     */
    public static FloatBinding min(final ObservableFloatValue a, final ObservableFloatValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(float, float)}
     */
    public static FloatBinding min(final float a, final ObservableFloatValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(float, float)}
     */
    public static FloatBinding min(final ObservableFloatValue a, final float b){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#min(int, int)}
     */
    public static IntegerBinding min(final ObservableIntegerValue a, final ObservableIntegerValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(int, int)}
     */
    public static IntegerBinding min(final int a, final ObservableIntegerValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(int, int)}
     */
    public static IntegerBinding min(final ObservableIntegerValue a, final int b){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#min(long, long)}
     */
    public static LongBinding min(final ObservableLongValue a, final ObservableLongValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(long, long)}
     */
    public static LongBinding min(final long a, final ObservableLongValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#min(long, long)}
     */
    public static LongBinding min(final ObservableLongValue a, final long b){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#multiplyExact(int, int)}
     */
    public static IntegerBinding multiplyExact(final ObservableIntegerValue x, final ObservableIntegerValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#multiplyExact(int, int)}
     */
    public static IntegerBinding multiplyExact(final int x, final ObservableIntegerValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#multiplyExact(int, int)}
     */
    public static IntegerBinding multiplyExact(final ObservableIntegerValue x, final int y){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#multiplyExact(long, long)}
     */
    public static LongBinding multiplyExact(final ObservableLongValue x, final ObservableLongValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#multiplyExact(long, long)}
     */
    public static LongBinding multiplyExact(final long x, final ObservableLongValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#multiplyExact(long, long)}
     */
    public static LongBinding multiplyExact(final ObservableLongValue x, final long y){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#negateExact(int)}
     */
    public static IntegerBinding negateExact(final ObservableIntegerValue a){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#negateExact(long)}
     */
    public static LongBinding negateExact(final ObservableLongValue a){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#nextAfter(double, double)}
     */
    public static DoubleBinding nextAfter(final ObservableDoubleValue start, final ObservableDoubleValue direction) {
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#nextAfter(double, double)}
     */
    public static DoubleBinding nextAfter(final double start, final ObservableDoubleValue direction){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#nextAfter(double, double)}
     */
    public static DoubleBinding nextAfter(final ObservableDoubleValue start, final double direction){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#nextAfter(float, double)}
     */
    public static FloatBinding nextAfter(final ObservableFloatValue start, final ObservableFloatValue direction){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#nextAfter(float, double)}
     */
    public static FloatBinding nextAfter(final float start, final ObservableFloatValue direction){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#nextAfter(float, double)}
     */
    public static FloatBinding nextAfter(final ObservableFloatValue start, final float direction){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#nextDown(double)}
     */
    public static DoubleBinding nextDown(final ObservableDoubleValue d){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#nextDown(float)}
     */
    public static FloatBinding nextDown(final ObservableFloatValue f){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#nextUp(double)}
     */
    public static DoubleBinding nextUp(final ObservableDoubleValue d){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#nextUp(float)}
     */
    public static FloatBinding nextUp(final ObservableFloatValue f){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#pow(double, double)}
     */
    public static DoubleBinding pow(final ObservableDoubleValue a, final ObservableDoubleValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#pow(double, double)}
     */
    public static DoubleBinding pow(final double a, final ObservableDoubleValue b){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#pow(double, double)}
     */
    public static DoubleBinding pow(final ObservableDoubleValue a, final double b){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#rint(double)}
     */
    public static DoubleBinding rint(final ObservableDoubleValue a){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#round(double)}
     */
    public static LongBinding round(final ObservableDoubleValue a){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#round(float)}
     */
    public static IntegerBinding round(final ObservableFloatValue a){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#scalb(double, int)}
     */
    public static DoubleBinding scalb(final ObservableDoubleValue d, final ObservableIntegerValue scaleFactor){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#scalb(double, int)}
     */
    public static DoubleBinding scalb(final double d, final ObservableIntegerValue scaleFactor){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#scalb(double, int)}
     */
    public static DoubleBinding scalb(final ObservableDoubleValue d, final int scaleFactor){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#scalb(float, int)}
     */
    public static FloatBinding scalb(final ObservableFloatValue f, final ObservableIntegerValue scaleFactor){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#scalb(float, int)}
     */
    public static FloatBinding scalb(final float f, final ObservableIntegerValue scaleFactor){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#scalb(float, int)}
     */
    public static FloatBinding scalb(final ObservableFloatValue f, final int scaleFactor){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#signum(double)}
     */
    public static DoubleBinding signum(final ObservableDoubleValue d){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#signum(float)}
     */
    public static FloatBinding signum(final ObservableFloatValue f){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#sinh(double)}
     */
    public static DoubleBinding sinh(final ObservableDoubleValue x){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#sqrt(double)}
     */
    public static DoubleBinding sqrt(final ObservableDoubleValue a){
        return null;
    }



    /**
     * Binding for {@link java.lang.Math#subtractExact(int, int)}
     */
    public static IntegerBinding subtractExact(final ObservableIntegerValue x, final ObservableIntegerValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#subtractExact(int, int)}
     */
    public static IntegerBinding subtractExact(final int x, final ObservableIntegerValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#subtractExact(int, int)}
     */
    public static IntegerBinding subtractExact(final ObservableIntegerValue x, final int y){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#subtractExact(long, long)}
     */
    public static LongBinding subtractExact(final ObservableLongValue x, final ObservableLongValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#subtractExact(long, long)}
     */
    public static LongBinding subtractExact(final long x, final ObservableLongValue y){
        return null;
    }
    /**
     * Binding for {@link java.lang.Math#subtractExact(long, long)}
     */
    public static LongBinding subtractExact(final ObservableLongValue x, final long y){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#tan(double)}
     */
    public static DoubleBinding tan(final ObservableDoubleValue a){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#tanh(double)}
     */
    public static DoubleBinding tanh(final ObservableDoubleValue x){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#toDegrees(double)}
     */
    public static DoubleBinding toDegrees(final ObservableDoubleValue angrad){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#toIntExact(long)}
     */
    public static IntegerBinding toIntExact(final ObservableLongValue value){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#toRadians(double)}
     */
    public static DoubleBinding toRadians(final ObservableDoubleValue angdeg){
        return null;
    }


    /**
     * Binding for {@link java.lang.Math#ulp(double)}
     */
    public static DoubleBinding ulp(final ObservableDoubleValue d){
        return null;
    }

    /**
     * Binding for {@link java.lang.Math#ulp(float)}
     */
    public static FloatBinding ulp(final ObservableFloatValue f){
        return null;
    }

}
