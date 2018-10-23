import java.util.*;

public class OverrideEquals {
	public static void main(String[] args) {
		TestEquals t1 = new TestEquals(1);
		List l = new ArrayList();
		l.add(t1);
		System.out.println(l.remove(new TestEquals(1)));
	}
}

class TestEquals {
	private int id;
	public TestEquals(int i) {
		id = i;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof TestEquals) {
			TestEquals test = (TestEquals)obj;
			if(test.id==id) return true;
		}
		return false;
	}
	@Override
    public int hashCode() {
        int result=16;
        result = result * 31 + new Integer(id).hashCode();
        return result;
    }
}