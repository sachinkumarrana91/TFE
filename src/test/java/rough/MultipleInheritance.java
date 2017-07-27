package rough;


public class MultipleInheritance implements PI1,PI2 {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		PI1.super.show();
		PI2.super.show();
	}

	public static void main(String[] args) {
		MultipleInheritance mi = new MultipleInheritance();
		mi.show();
	}
}



