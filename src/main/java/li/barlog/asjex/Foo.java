package li.barlog.asjex;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
@Data
public class Foo {
	private int i;
    public void foo() {
        log.log(Level.SEVERE, "foo");
    }
}
