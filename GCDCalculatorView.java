import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class GCDCalculatorView extends JFrame
{
	//exits the calculator
    private JButton btnQuitProgram;
    //clears the first number, second number, and gcd result labels' text
    private JButton btnClearAll;
    //takes input from first and second number jlabels and calls greatestCommonDivisor method of model to calculate GCD
    private JButton btnCalculate;
    //label to designate text field for the first number
    private JLabel jLabelFirstNumber;
    //label to designate text field for the second number
    private JLabel jLabelSecondNumber;
    //label to designate where GCD result is displayed
    private JLabel jLabelGCD;
    //label text is set to the value returned by calling greatestCommonDivisor method of model to calculate GCD when btnCalculate is pressed
    private JLabel gcdResult;
    //input area for first number
    private JTextField txtNum1;
    //input area for second number
    private JTextField txtNum2;
	
    //Constructor that must be a provided a name, which will appear in the title of the GUI, and that
	//initializes the GUI components
	public GCDCalculatorView(String name)
    {
        super(name);
        //initialize GUI components
        initComponents();
    }
	
	//method called in the constructor to initialize the GUI components
    private void initComponents()
    {
        jLabelFirstNumber = new JLabel();
        jLabelSecondNumber = new JLabel();
        txtNum1 = new JTextField();
        txtNum2 = new JTextField();
        btnCalculate = new JButton();
        btnClearAll = new JButton();
        btnQuitProgram = new JButton();
        jLabelGCD = new JLabel();
        gcdResult = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabelFirstNumber.setText("First number");
        jLabelSecondNumber.setText("Second number");
        btnCalculate.setText("Calculate GCD");
        //enable calculate button functionality on mouse press
        btnCalculate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnCalculateActionPerformed(evt);
            }
        });

        btnClearAll.setText("Clear All");
        //enable clear button functionality on mouse press
        btnClearAll.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnClearAllActionPerformed(evt);
            }
        });

        btnQuitProgram.setText("Quit GCD Calculator");
        //enable quit button functionality on mouse press
        btnQuitProgram.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnQuitProgramActionPerformed(evt);
            }
        });
        jLabelGCD.setText("GCD");
        setLayout();
        //automatically resizes window
        pack();
        //show the GUI 
        setVisible(true);
    }

    //take input of first number and second number fields, convert inputs to integers, pass integers to gcd method in model,
    //parse return value to string, set gcd result label to display the returned value
    private void btnCalculateActionPerformed(ActionEvent evt)
    {
        try{
                        int valueFirst=Integer.parseInt(txtNum1.getText());
                        int valueSecond=Integer.parseInt(txtNum2.getText());
                        gcdResult.setText(Integer.toString(GCDCalculatorModel.greatestCommonDivisor(valueFirst,valueSecond)));

                }
        catch(Exception e)
        {
            gcdResult.setText("Operation failed");
        }
    }
    
    
    //when the clear button is pressed, the fields with the first and second number and the label text that displays the gcd result are cleared
    private void btnClearAllActionPerformed(ActionEvent evt)
    {

        try
        {
            txtNum1.setText("");
            txtNum2.setText("");
            gcdResult.setText("");
        }
        catch(Exception e)
        {
            gcdResult.setText("Operation failed");
        }
    }


    //when the quit button is pressed, the application uses a system call to exit
    private void btnQuitProgramActionPerformed(ActionEvent evt)
    {
        try
        {
            System.exit(0);
        }
        catch(Exception e)
        {
            gcdResult.setText("Operation failed");
        }
    }
    
    
//defines the layout of the GUI components; this method appears in initComponents and can be changed to drastically alter the 
//GUI appearance by defining a new layout; if you're looking to change label text, you want to look in the initComponents method;
//if you want to change the GUI appearance, this is generally the method you're looking to alter
private void setLayout(){
    	GroupLayout calculator = new GroupLayout(getContentPane());
        getContentPane().setLayout(calculator);
        calculator.setHorizontalGroup(calculator.createParallelGroup(GroupLayout.Alignment.LEADING)

.addGroup(calculator.createSequentialGroup()
                .addGap(55, 55, 55)
.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(calculator.createSequentialGroup()
                        .addComponent(jLabelGCD)
                        	.addContainerGap())
.addGroup(calculator.createSequentialGroup()

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(calculator.createSequentialGroup()

.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalculate)

.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearAll)

.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitProgram))
                            .addGroup(calculator.createSequentialGroup()

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFirstNumber)
                                    .addComponent(jLabelSecondNumber))
                                .addGap(75, 75, 75)

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNum2,
GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(gcdResult)
                                    .addComponent(txtNum1,
GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                        .addGap(61, 61, 61))))
        );
        
calculator.setVerticalGroup(
            calculator.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(calculator.createSequentialGroup()
                .addGap(65, 65, 65)

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNum1, GroupLayout.PREFERRED_SIZE,
GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFirstNumber))
                .addGap(18, 18, 18)

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSecondNumber)
                    .addComponent(txtNum2, GroupLayout.PREFERRED_SIZE,
GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(gcdResult)
                    .addComponent(jLabelGCD))
                .addGap(18, 18, 18)

.addGroup(calculator.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate)
                    .addComponent(btnClearAll)
                    .addComponent(btnQuitProgram))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }
}
