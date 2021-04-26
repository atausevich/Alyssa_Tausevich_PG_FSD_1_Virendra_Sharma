package program.java.virtualkey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*---------------------------------------------------------------------
|  	Developer Name: Alyssa Tausevich
|	Project: Locked Me.Com 
|	Client: Lockers Pvt. Ltd. 
|	Application Specifications: 
|		•	Retrieving the file names in an ascending order
|		•	Business-level operations:
|		•	Option to add a user specified file to the application
|		•	Option to delete a user specified file from the application
|		•	Option to search a user specified file from the application
|		•	Navigation option to close the current execution context and return to the main context
|		•	Option to close the application
|	Goal: Deliver high end quality product ASAP
*----------------------------------------------------------------------*/

public class App {	   
	
	static List <String> return_files = new ArrayList<String>();
	static File[] files = new File("C:\\INFO2970\\program.jav").listFiles();
		
	public static void Welcome()
	{		
		System.out.println("|***********Application Name: Locked Me***************|");
		System.out.println("|***********Developer Name: Alyssa Tausevich**********|\n");
	}
	
	/*---------------------------------------------------------------------
    |  Method: Main_Menu
    |
    |  Purpose: to display the main_options of the application including user specified 
    |  			access to the business level file directory using switch cases
    |			
    |  Returns: user-specified options, current_file list, close application or 
    |			business level file directory for file handling
    *----------------------------------------------------------------------*/	
		
	public static void Main_Menu() throws FileNotFoundException
	{		Scanner input = new Scanner(System.in); 
			int main_option;		
			
		do{				
			System.out.println("Main Application Menu"); 
			System.out.println("1. Return Current File Names in Ascending Order"); 
			System.out.println("2. Access Business Level File Directory Menu"); 
			System.out.println("3. Close Application \n"); 		
			System.out.println("Choose a Menu Option: ");			
		
			main_option = input.nextInt();
			switch(main_option) 
			{
			case 1: 
				return_current_files();
				break;
			
			case 2: 			
				
				/*---------------------------------------------------------------------
			    | Case 2:
			    |  	Purpose: Navigate from Main Menu to Business Level File Directory Menu 
			    |	Contains Methods: add_file, delete_file, search_file, returns 
			    |	business_option to main menu 
			    *----------------------------------------------------------------------*/			
				
				int business_option;
				do{							
					System.out.println("\nBusiness Level File Directory Menu\n"); 
					System.out.println("1. Add a File to Existing Directory"); 
					System.out.println("2. Delete a File from Existing Directory"); 
					System.out.println("3. Search a File from Existing Directory"); 
					System.out.println("4. Return to Main Application Menu\n"); 
					System.out.println("Choose a Menu Option: ");			
					
					business_option = input.nextInt();
					switch(business_option) 
					{			
					case 1:
						add_file();
						break;
					case 2:
						delete_file();
						break;
					case 3:
						search_file();
						break;
					case 4:
						System.out.println("Returning to the Main Application Menu... \n");
						break;
						
					default:
						System.out.println("Error: Invalid Selection");				
					} 
				} while (business_option !=4);
				break;
				
				case 3: 
					System.out.println("Closing application...");
					break;
					
					default:
						System.out.println("Error: Invalid Selection");				
				} 		
						
				} while(main_option !=3);					
			}
			
			/*---------------------------------------------------------------------
		    |  Method: return_current_files
		    |
		    |  Purpose: to identify existing files in directory in ascending order (default)      
		    |			using an ArrayList
		    |  Returns: files in directory in ascending order 
		    *----------------------------------------------------------------------*/				
			
			public static void return_current_files() 
			{
				for (File file : files) 
				{
					if(file.isFile()) 
					{
						return_files.add(file.getName());
					}
				}
			System.out.println(return_files);	
			}	
			
			/*---------------------------------------------------------------------
		    |  Method: add_file
		    |
		    |  Purpose: uses a try/catch to add a user specified file to existing directory and 
		    |   		check for existing files
		    |  Returns: file added to directory as successful, file already exists error 
		    *----------------------------------------------------------------------*/
			
			public static void add_file() 
			{		
				Scanner input = new Scanner(System.in);
				System.out.println("Enter File Name to Add: ");
				String file_name = input.nextLine();
				File file = new File (file_name);	
						
			{
					try {
						if (file.createNewFile()) 				
						{
							System.out.println("File added to directory: " + file_name);
								
						}else 
						{
							System.out.println("File already exists");
						}
					} catch (IOException e) {						
						e.printStackTrace();
					}					
			}
			}
			
			/*---------------------------------------------------------------------
		    |  Method: delete_file
		    |
		    |  Purpose:  uses an if/else statement to determine if a user specified file 
		    |			 is present to be deleted else returns a File Not Found error.		 	
		    |  Returns:  Returns file deleted confirmation or File Not Found error
		    *----------------------------------------------------------------------*/
			
			public static void delete_file() 
			{		
				Scanner input = new Scanner(System.in);	
				System.out.println("Enter File Name to Delete: ");
				String file_name = input.nextLine();
				File file = new File (file_name);
				
				{
					if (file.delete()) 
					{
						System.out.println("File Deleted: " + file_name);
					}else 
					{
						System.out.println("File Not Found");
					}
				}
			}
			
			 /*---------------------------------------------------------------------
		    |  Method: search_file
		    |
		    |  Purpose: to search existing directory for a user specified file		
		    |  Returns: File exists confirmation or File Not Found error with a user submit re-enter 
		    |			a valid file name
		    *----------------------------------------------------------------------*/

			public static void search_file() 
			{	File file;	
				Scanner input = new Scanner(System.in);
				System.out.println("Enter File Name to Search For");
				String name = input.nextLine();				
				file = new File (name);
				
				if (!file.exists())
				{					
					do {
						System.out.println("Error. File not found");			  
					    System.out.println("Please Re-enter a File Name: ");
					    
					    name = input.nextLine();
					    file = new File(name);
					    
					    } while (!file.exists()); 			
						System.out.println("File exists");	
				}                             
			}
	public static void main(String[] args) {		
		
			try
			{
				Main_Menu();
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}

		}
	}
