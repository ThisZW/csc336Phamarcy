import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Display extends JFrame{
    //private Patient currentEntry;
    private Queries q;
    private List<Patient> results;
    private int numberofEntries = 0;
    private int currentEntryIndex;
    private int IndexOfDelete;
    private JButton browseButton;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JLabel idLabel;
    private JTextField idTextField;
    private JTextField indexTextField;
    private JTextField maxTextField;
    private JButton nextButton;
    private JLabel ofLabel;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JButton previousButton;
    private JButton queryButton;
    private JLabel queryLabel;
    private JPanel queryPanel;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;
    private JButton insertButton;
    private JLabel addressLabel;
    private JTextField addressTextField;
    private JButton deleteButton;
    private JButton updateButton;
    private JLabel CompanynameLabel;
    private JTextField CompanynameTextField;
    private JLabel PaymentMethodLabel;
    private JTextField PaymentMethodTextField;
    private JLabel PatientIDLabel;
    private JTextField PatientIDTextField;
    private JLabel PrescriberIDLabel;
    private JTextField PrescriberIDTextField;
    private JLabel DateoffilledLabel;
    private JTextField DateoffilledTextField;
    private JLabel DrugnameLabel;
    private JTextField DrugnameTextField;
    private JLabel DrugcostLabel;
    private JTextField DrugcostTextField;
    private JLabel AmountLabel;
    private JTextField AmountTextField;
    private JLabel UnitLabel;
    private JTextField UnitTextField;
    private JLabel DoseLabel;
    private JTextField DoseTextField;
    private JLabel DrugcompanyLabel;
    private JTextField DrugcompanyTextField;
    private JLabel DrugIDLabel;
    private JTextField DrugIDTextField;
    private ArrayList<Patient> data = new ArrayList<Patient>();
    
    public Display() {
        super("Patients");
        q = new Queries();
        navigatePanel = new JPanel();
        previousButton = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        nextButton = new JButton();
        displayPanel = new JPanel();
        idLabel = new JLabel();
        idTextField = new JTextField(10);
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField(10);
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField(10);
        emailLabel = new JLabel();
        emailTextField = new JTextField(10);
        phoneLabel = new JLabel();
        phoneTextField = new JTextField(10);
        addressLabel = new JLabel();
        addressTextField = new JTextField(10);
        CompanynameLabel = new JLabel();
        CompanynameTextField =new JTextField(10);
        PaymentMethodLabel=new JLabel();
        PaymentMethodTextField = new JTextField(10);
        PatientIDLabel=new JLabel();
        PatientIDTextField = new JTextField(10);
        PrescriberIDLabel= new JLabel();
        PrescriberIDTextField = new JTextField(10);
        DateoffilledLabel = new JLabel();
        DateoffilledTextField = new JTextField(10);
        DrugnameLabel=new JLabel();
        DrugnameTextField= new JTextField(10);
        DrugcostLabel=new JLabel();
        DrugcostTextField = new JTextField(10);
        AmountLabel = new JLabel();
        AmountTextField = new JTextField(10);
        UnitLabel = new JLabel();
        UnitTextField = new JTextField(10);
        DoseLabel = new JLabel();
        DoseTextField = new JTextField(10);
        DrugcompanyLabel = new JLabel();
        DrugcompanyTextField = new JTextField(10);
        DrugIDLabel = new JLabel();
        DrugIDTextField = new JTextField(10);
        queryPanel = new JPanel();
        queryLabel = new JLabel();
        queryTextField = new JTextField(10);
        queryButton = new JButton();
        browseButton = new JButton();
        insertButton = new JButton();
        deleteButton = new JButton();
        updateButton = new JButton();
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(430, 800);
        setResizable(true);
        
        
        
        
        navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
        previousButton.setText("Previous");
        previousButton.setEnabled(false);
        previousButton.addActionListener(
                                         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previousButtonActionPerformed(e);
            }
        }
                                         );
        
        navigatePanel.add(previousButton);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        indexTextField.setHorizontalAlignment(JTextField.CENTER);
        indexTextField.addActionListener(
                                         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setTextFieldsByCurrentEntryIndex( Integer.parseInt(indexTextField.getText())+1);
            }
        }
                                         );
        
        navigatePanel.add(indexTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        ofLabel.setText("of");
        navigatePanel.add(ofLabel);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        maxTextField.setHorizontalAlignment(JTextField.CENTER);
        maxTextField.setEditable(false);
        navigatePanel.add(maxTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        
        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(
                                     new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButtonActionPerformed(e);
            }
        }
                                     );
        
        navigatePanel.add(nextButton);
        add(navigatePanel);
        
        displayPanel.setLayout(new GridLayout(18, 9, 12, 12));
        
        idLabel.setText("Id:");
        displayPanel.add(idLabel);
        idTextField.setEditable(true);
        displayPanel.add(idTextField);
        
        firstNameLabel.setText("First Name:");
        displayPanel.add(firstNameLabel);
        displayPanel.add(firstNameTextField);
        
        lastNameLabel.setText("Last Name:");
        displayPanel.add(lastNameLabel);
        displayPanel.add(lastNameTextField);
        
        phoneLabel.setText("Phone Number:");
        displayPanel.add(phoneLabel);
        displayPanel.add(phoneTextField);
        
        addressLabel.setText("Address");
        displayPanel.add(addressLabel);
        displayPanel.add(addressTextField);
        
        
        //CompanynameLabel.setText("Company name");
        //displayPanel.add(CompanynameLabel);
        //displayPanel.add(CompanynameTextField);
        
        PaymentMethodLabel.setText("Payment Method");
        displayPanel.add(PaymentMethodLabel);
        displayPanel.add(PaymentMethodTextField);
        
        /*PatientIDLabel.setText("Patient ID");
        displayPanel.add(PatientIDLabel);
        displayPanel.add(PatientIDTextField);*/
        
        PrescriberIDLabel.setText("PrescriberID");
        displayPanel.add(PrescriberIDLabel);
        displayPanel.add(PrescriberIDTextField);
        
        DateoffilledLabel.setText("Date of filled");
        displayPanel.add(DateoffilledLabel);
        displayPanel.add(DateoffilledTextField);
        
        DrugnameLabel.setText("Drug name");
        displayPanel.add(DrugnameLabel);
        displayPanel.add(DrugnameTextField);
        
        DrugcostLabel.setText("Drug cost");
        displayPanel.add(DrugcostLabel);
        displayPanel.add(DrugcostTextField);
        
        AmountLabel.setText("Amount");
        displayPanel.add(AmountLabel);
        displayPanel.add(AmountTextField);
        
        UnitLabel.setText("Unit");
        displayPanel.add(UnitLabel);
        displayPanel.add(UnitTextField);
        
        DoseLabel.setText("Dose");
        displayPanel.add(DoseLabel);
        displayPanel.add(DoseTextField);
        
        DrugcompanyLabel.setText("Drug company");
        displayPanel.add(DrugcompanyLabel);
        displayPanel.add(DrugcompanyTextField);
        
        DrugIDLabel.setText("Drug ID");
        displayPanel.add(DrugIDLabel);
        displayPanel.add(DrugIDTextField);
        
        add(displayPanel);
        
        queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
        queryPanel.setBorder(BorderFactory.createTitledBorder("Find an entry by State"));
        queryLabel.setText("Address:");
        queryPanel.add(Box.createHorizontalStrut(5));
        queryPanel.add(queryLabel);
        queryPanel.add(Box.createHorizontalStrut(10));
        queryPanel.add(queryTextField);
        queryPanel.add(Box.createHorizontalStrut(10));
        
        
        browseButton.setText("Browse All Entries");
        browseButton.addActionListener(
                                       new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browseButtonActionPerformed(e);
            }
        }
                                       );
        
        insertButton.setText("Insert");
        insertButton.addActionListener(
        								new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		insertButtonActionPerformed(e);
        	}
        });
        
        deleteButton.setText("Delete");
        deleteButton.addActionListener(
        								new ActionListener(){
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 deleteButtonActionPerformed(e);
	         }
         });
        
        updateButton.setText("Update Patient Info");
        updateButton.addActionListener(
        								new ActionListener(){
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 updateButtonActionPerformed(e);
	         }}
        );
        
        
        add(browseButton);
        add(insertButton);
        add(deleteButton);
        add(updateButton);
        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new BorderLayout());
        JTextArea comments = new JTextArea();
        comments.setText(
        		"Some instructions for current status of this app:\n"
        		+ "address followed by the format ex: 1141 65st,brooklyn,ny,usa,11219 \n(has to be 4 commas)\n"
        		+ "date format is followed by MMddyyyy\n"
        		+ "UPDATE at this time will only update first,last names and phone number\n"
        		+ "Prescriber ID should set to 1."
        		);
        add(commentPanel);
        comments.setPreferredSize(new Dimension(400, 100));
        commentPanel.add(comments, BorderLayout.CENTER);
        addWindowListener(
                          new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                q.close();
                System.exit(0);
            }
        }
                          );
        setVisible(true);
    }
    
    private void previousButtonActionPerformed(ActionEvent e) {
        currentEntryIndex--;
        if(currentEntryIndex < 0)
            currentEntryIndex = numberofEntries -1;
        
        indexTextField.setText("" + (currentEntryIndex + 1));
        setTextFieldsByCurrentEntryIndex(currentEntryIndex);
    }
    
    private void nextButtonActionPerformed(ActionEvent e){
        currentEntryIndex++;
        
        if(currentEntryIndex >= numberofEntries)
            currentEntryIndex = 0;
        indexTextField.setText(""+ (currentEntryIndex+1));
        setTextFieldsByCurrentEntryIndex(currentEntryIndex);
    }
    
    private void deleteButtonActionPerformed(ActionEvent e){
    	int id = Integer.parseInt(idTextField.getText());
    	q.deleteDataByPatientId(id);
    	browseButtonActionPerformed(e);
    	/*data.remove(currentEntryIndex);
    	if (currentEntryIndex != 0){
    		currentEntryIndex--;
    		indexTextField.setText(""+ currentEntryIndex);
    	}
    	setTextFieldsByCurrentEntryIndex(currentEntryIndex);
    	maxTextField.setText("" + data.size());*/
    }
    
    /*private void indexTextFieldActionPerformed(ActionEvent e){
        currentEntryIndex = (Integer.parseInt(indexTextField.getText())-1);
        
        if(numberofEntries != 0 && currentEntryIndex < numberofEntries) {
            currentEntry = results.get(currentEntryIndex);
            idTextField.setText(""+currentEntry.getID());
            firstNameTextField.setText(currentEntry.getFirstName());
            lastNameTextField.setText(currentEntry.getLastName());
            emailTextField.setText(currentEntry.getEmail());
            phoneTextField.setText(Integer.toString(currentEntry.getPhoneNumber()));
            addressTextField.setText(Integer.toString(currentEntry.getAddress()));
            maxTextField.setText(""+numberofEntries);
            indexTextField.setText(""+(currentEntryIndex+1));
            
        }
    }*/
    
    private void browseButtonActionPerformed(ActionEvent e){
        try {
        	data.clear();
        	//Queries q = new Queries();
            ResultSet results = q.browseAllDataFromDatabase();
            while (results.next()){
            	Patient p = new Patient(results.getInt(1),
            			results.getString(2),
            			results.getString(3),
            			results.getString(4),
            			results.getString(5),
            			results.getString(6),
            			results.getInt(7),
            			results.getString(8),
            			results.getString(9),
            			results.getDouble(10),
            			results.getDouble(11),
            			results.getInt(12),
            			results.getInt(13),
            			results.getString(14),
            			results.getInt(15)
            			);
            	data.add(p);
            }
            numberofEntries = data.size()+1;
            indexTextField.setText("1");
            maxTextField.setText(String.valueOf(numberofEntries));
            if (numberofEntries != 0) {
                currentEntryIndex = 0;
                setTextFieldsByCurrentEntryIndex(currentEntryIndex);
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    
    private void setTextFieldsByCurrentEntryIndex(int i){
        idTextField.setText("" + data.get(i).getID());
        firstNameTextField.setText(data.get(i).getFirstName());
        lastNameTextField.setText(data.get(i).getLastName());
        phoneTextField.setText(data.get(i).getPhoneNumber());
        addressTextField.setText(data.get(i).getAddress());
        
        PaymentMethodTextField.setText( data.get(i).getPaymentMethod());
        PrescriberIDTextField.setText("" + data.get(i).getPrescriberId());
        DateoffilledTextField.setText("" + data.get(i).getDateOfFilled());
        DrugnameTextField.setText(data.get(i).getDrugName());
        DrugcostTextField.setText("" +  data.get(i).getDrugCost());
        
        AmountTextField.setText("" +  data.get(i).getAmount());
        UnitTextField.setText("" +  data.get(i).getUnit());
        DoseTextField.setText("" +  data.get(i).getDose());
        DrugcompanyTextField.setText(""+  data.get(i).getDrugCompany());
        DrugIDTextField.setText("" + data.get(i).getDrugId());
        
        nextButton.setEnabled(true);
        previousButton.setEnabled(true);
    }
    
    private void insertButtonActionPerformed(ActionEvent e){
    	try{
    		//we don't need to input ID while doing insert
    		String idString = idTextField.getText();
    		int id;
    		if (idString.isEmpty()){
    			id = 0;
    		} else id = Integer.parseInt(idString);
    		
    		//System.out.println(idTextField.getText());
    		Patient p = new Patient(id,//Integer.parseInt(idTextField.getText()),
    				firstNameTextField.getText(),
    				lastNameTextField.getText(),
    				phoneTextField.getText(),
    				addressTextField.getText(),
    				PaymentMethodTextField.getText(),
    				Integer.parseInt(PrescriberIDTextField.getText()),
    				//dateoffilled input format: MMddyyyy
    				DateoffilledTextField.getText(),
    				DrugnameTextField.getText(),
    				Double.parseDouble(DrugcostTextField.getText()),
    				Double.parseDouble(AmountTextField.getText()),
    				Integer.parseInt(UnitTextField.getText()),
    				Integer.parseInt(DoseTextField.getText()),
    				DrugcompanyTextField.getText(),
    				Integer.parseInt(DrugIDTextField.getText()));
    		//Queries q = new Queries(p);
    		q.setPatient(p);
    		q.insertDataIntoDatabase();
    		browseButtonActionPerformed(e);
    	}
    	catch (Exception exception){
    		exception.printStackTrace();
    	}
    }
    
    private void updateButtonActionPerformed(ActionEvent e){
    	try{
			/* Patient p = new Patient(idTextField.getHeight(),//Integer.parseInt(idTextField.getText()),
					firstNameTextField.getText(),
					lastNameTextField.getText(),
					phoneTextField.getText(),
					addressTextField.getText(),
					PaymentMethodTextField.getText(),
					Integer.parseInt(PrescriberIDTextField.getText()),
					DateoffilledTextField.getText(),
					DrugnameTextField.getText(),
					Double.parseDouble(DrugcostTextField.getText()),
					Double.parseDouble(AmountTextField.getText()),
					Integer.parseInt(UnitTextField.getText()),
					Integer.parseInt(DoseTextField.getText()),
					DrugcompanyTextField.getText(),
					Integer.parseInt(DrugIDTextField.getText())); */
    		Patient p = new Patient();
    		//let's only update patient table at this time.
    		p.setID(Integer.parseInt(idTextField.getText()));
    		p.setFirstName(firstNameTextField.getText());
    		p.setLastName(lastNameTextField.getText());
    		p.setPhoneNumber(phoneTextField.getText());
			q.setPatient(p);
			q.updateDataByPatientId();
			browseButtonActionPerformed(e);
		}
    	catch (Exception exception){
    		exception.printStackTrace();
    	}
		
    }

    public static void main(String[] args) {
        new Display();
    }
    
}

