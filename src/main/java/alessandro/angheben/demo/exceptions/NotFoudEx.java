package alessandro.angheben.demo.exceptions;

public class NotFoudEx extends RuntimeException {


        public NotFoudEx(long id) {
            super("item with " + id + " not found.");
        }

}
