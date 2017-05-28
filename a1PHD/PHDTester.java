import static org.junit.Assert.*;

import org.junit.Test;

public class PHDTester {

	@Test
	public void testConstructor1() {
		PHD p1 = new PHD("Bob Marley",'m', 1990, 5);
		PHD p2 = new PHD("Adele Adkins", 'f',2006, 8);
		assertEquals("Bob Marley",p1.getName());
		assertEquals(5,p1.getMonth());
		assertEquals(1990,p1.getYear());
		assertEquals(true,p1.isMale());
		assertEquals(null,p1.advisor1());
		assertEquals(null,p1.advisor2());
		assertEquals(0,p1.numAdvises());
		assertEquals("Adele Adkins",p2.getName());
		assertEquals(8,p2.getMonth());
		assertEquals(2006,p2.getYear());
		assertEquals(false,p2.isMale());
		assertEquals(null,p2.advisor1());
		assertEquals(null,p2.advisor2());
		assertEquals(0,p2.numAdvises());	
	}

	@Test
	public void testSetter(){
		PHD p1 = new PHD("Adele Adkins", 'f',2006, 8);
		PHD firstAdvisor = new PHD("Frank Ocean", 'm',2005, 9);
		PHD secondAdvisor= new PHD("Beyonce Knowles", 'f',1997, 1);
		p1.setAdvisor1(firstAdvisor);
		assertEquals(firstAdvisor, p1.advisor1());
		assertEquals(1,firstAdvisor.numAdvises());
		p1.setAdvisor2(secondAdvisor);
		assertEquals(secondAdvisor, p1.advisor2());
		assertEquals(1,secondAdvisor.numAdvises());
	}

	@Test
	public void testNewConstructors(){
		/**The two PHD objects using first constructor*/
		PHD p1 = new PHD("Bruno Mars",'m', 2000, 3);
		PHD p2 = new PHD("Etta James", 'f',1980, 7);

		/**First constructor of Group C*/
		PHD p3 = new PHD("Whitney Elizabeth Houston",'f', 1977, 6, p1);
		assertEquals("Whitney Elizabeth Houston",p3.getName());
		assertEquals(6,p3.getMonth());
		assertEquals(1977,p3.getYear());
		assertEquals(false,p3.isMale());
		assertEquals(p1,p3.advisor1());
		assertEquals(null,p3.advisor2());
		assertEquals(0,p3.numAdvises());
		assertEquals(1,p1.numAdvises());

		/**Second constructor of Group C*/
		PHD p4 = new PHD("Justin Timberlake", 'm', 1992, 2, p1, p2);
		assertEquals("Justin Timberlake",p4.getName());
		assertEquals(2,p4.getMonth());
		assertEquals(1992,p4.getYear());
		assertEquals(true,p4.isMale());
		assertEquals(p1,p4.advisor1());
		assertEquals(p2,p4.advisor2());
		assertEquals(0,p4.numAdvises());
		assertEquals(2,p1.numAdvises());
		assertEquals(1,p2.numAdvises());
	}

	@Test
	public void testComparisonMethods(){
		PHD p1 = new PHD("Bruno Mars",'m', 2000, 3);
		PHD p2 = new PHD("Etta James", 'f',2000, 7);
		PHD p3 = new PHD("Beyonce Knowles", 'f',1997, 1);
		PHD p4 = new PHD("Whitney Elizabeth Houston",'f', 1977, 6, p1, p3);
		PHD p5 = new PHD("Justin Timberlake", 'm', 1992, 2, p1, p2);
		PHD p6 = new PHD("Frank Ocean", 'm', 2002, 3, p2, p3);
		PHD p7 = new PHD("Taylor Swift",'f',2000, 3, p4, p2);
		assertEquals(true, p4.gotBefore(p5));
		assertEquals(true,p1.gotBefore(p2));
		assertEquals(false,p1.gotBefore(p4));
		assertEquals(false,p2.gotBefore(p1));
		assertEquals(false,p1.gotBefore(p7));
		assertEquals(true,p4.arePHDSiblings(p5));
		assertEquals(true,p4.arePHDSiblings(p6));
		assertEquals(true,p5.arePHDSiblings(p6));
		assertEquals(true,p6.arePHDSiblings(p7));
		assertEquals(false,p7.arePHDSiblings(p4));
	}
}
