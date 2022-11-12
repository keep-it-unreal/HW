package HW_L5_T2_Equals;

import java.util.Objects;

public class DigitHandler {
    private int value;

    public DigitHandler(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        DigitHandler that = (DigitHandler) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
