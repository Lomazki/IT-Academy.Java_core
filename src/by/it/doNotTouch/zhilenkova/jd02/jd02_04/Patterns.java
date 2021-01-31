package by.it.doNotTouch.zhilenkova.jd02.jd02_04;

final class Patterns {
    static final String OPERATION="(?<![-+*/={,])([-+=*/])";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?))+},?)+}";
}
