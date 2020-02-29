package epam.com.Logger;
import java.util.Scanner;
import org.apache.logging.log4j.*;
public class App
{
	private static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args ){
    	Scanner in=new Scanner(System.in);
        logger.debug("Enter Your Option:\n1.Calculate Interest\n2.Estimate House Construction Cost");
        int option=in.nextInt();
        while(option<1 || option>2) {
        	logger.debug("Enter a valid option\n");
        	option=in.nextInt();
        }
        if(option==1) {
        	logger.debug("Enter Principle Amount : ");
        	double p=in.nextDouble();
        	logger.debug("Enter Rate Of Interest : ");
        	double r=in.nextDouble();
        	logger.debug("Enter Time Taken : ");
        	double t=in.nextDouble();
        	logger.debug("Enter your type:\n1 Simple Interest\n2 Compound Interest");
        	int type=in.nextInt();
        	switch(type) {
        		case(1):
        			Simple s=new Simple(p,t,r);
        			logger.debug("SIMPLE INTEREST : "+ s.cal()+"INR");
        			break;
        		case(2):
        			Compound c=new Compound(p,t,r);
        			logger.debug("COMPOUND INTEREST : "+c.cal()+"INR");
        			break;
        	}
        }
        else {
        	logger.debug("Enter Area Of The House : ");
        	double area=in.nextDouble();
        	logger.debug("Enter Material Standards you need : ");
        	logger.debug("1.Standard Material\n2.Above Standard Material\n3.High Standard Material\n4.High Standard Material And Fully Automated House");
        	int op=in.nextInt();
        	House h=new House(area,op);
        	logger.debug("TOTAL COST : "+h.total() +"INR");
        }
        in.close();
    }
}