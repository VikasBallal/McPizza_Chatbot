# McPizzaChatbot

This file explaines about how to execute automation and folder contents of manual testing.

Manual_Testing Folder Contains
  - A file with functional test cases of McPizza Chatbot(McPizza_Chatbot_Functinal_Tests.feature)
  - A file with Non functional test cases of McPizza Chatbot(McPizza_Chatbot_NonFunctinal_Tests.feature)
  - A file with Blockers/issues in the McPizza Chatbot application
  
Automation Execution:

Pre-requisites

1. Latest version of JDK should be installed in your computer.
     - if not done please go through the link: https://docs.oracle.com/en/java/javase/13/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA

2. clone the github code to your local repository using below clone url:
     - Clone URL : 
     - Follow the steps in thie link to clone a git repository using Git Bash: https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository?platform=windows

There are two ways one can execute this automation, please make your choice:

1st way  using commad line:

1. Latest version of Maven should be set up.
	 - if not done please follow the link: https://maven.apache.org/install.html
   
2. From windows sart, search for cmd and run command prompt as administrator
![image](https://user-images.githubusercontent.com/45257587/227979067-af4ba11c-89fd-4029-a22f-0c5742bf9f11.png)

3. Change the path in terminal to your local machine cloned repo.
![image](https://user-images.githubusercontent.com/45257587/227979963-68f73867-da5f-46f2-82a6-8f0c9ef66638.png)
![image](https://user-images.githubusercontent.com/45257587/227980092-1b95aea7-c783-4d47-b4df-5732cbeb725e.png)

4. You can run the automation using command "mvn test", test execution will start.
![image](https://user-images.githubusercontent.com/45257587/227980937-04cd2aee-1229-4096-af0e-8ba359077ee4.png)

5. In case test execution did not start due to any error. Please run "mvn test" command again. Initially jdk would fail to copy all the compiled files, when you run the command for second time, it should automatically resolve the issue.
![image](https://user-images.githubusercontent.com/45257587/228007740-3c47ef16-0b45-4458-a5bf-10fdfc01c3dd.png)


2nd way using eclipse editor:

1. Open eclipse editor.
2. click on File > Import > Maven Project
3. select your local automation repo and click on finish
   ![image](https://user-images.githubusercontent.com/45257587/227986081-0ec3bd03-5ffd-4aa8-b55e-db891ef64ced.png)
4. Once the project is imported, convert it into cucumber project so that you would be able to navitage from fearute file to step definitions.
   ![image](https://user-images.githubusercontent.com/45257587/227988660-0595ec2a-d064-456d-8474-6b7b6f2407d2.png)
5. Wait until the dependencies are downloaded
6. Right click on the project and select run as JUnit test. Test execution will start.
   ![image](https://user-images.githubusercontent.com/45257587/227989012-a9e56504-4a1e-4b56-a6b9-0400a6fc97db.png)

Below are the scenarios automation will run.

 - Scenario: Validate login functionality of McPizza agent chatbot - (Cross browser is enabled, this scenario runs on both firefox and chrome)
 - Scenario: Order different types of veg pizza and validate the order creation using the quick replies in the chatbot (Cross browser is enabled, this scenario runs on both firefox and chrome)
 - Scenario: Order different types of veg pizza and provide thumbs up feedback (Cross browser is not enabled, runs only on chrome)
 - Scenario: Order different types of non-veg pizza and validate the order creation without using quick replies in the chatbot (Cross browser is not enabled, runs only on chrome)
 - Scenario: Order different types of non-veg pizza and provide thumbs down feedback (Cross browser is not enabled, runs only on chrome)
 
 NOTES:
  - Test run configuration can be updated in Junit TestRunner class, currently test are run by their tags.
   ![image](https://user-images.githubusercontent.com/45257587/227992302-8e27204d-0de0-41f7-a9f5-0b721e4a36a4.png)
   
  - Used aventStack extent report for automation execution reporting, every time the test(s) is/are run a new reporting folder will be created under test-output folder in the project location.
  
  - This folder can be viewed either from eclipse or on the local directory(when the test are run using terminal), one can open the .html file in any browsers to see the report.
    ![image](https://user-images.githubusercontent.com/45257587/227998825-97a8ff37-898d-4980-95f4-1bd935d742d8.png)
    ![image](https://user-images.githubusercontent.com/45257587/227999122-50db6b56-a3fb-44aa-aa6b-5beb3037e781.png)
    
  - Currently test data like user name and emailId are passed through the tests, this implementation can be chaged to read it from data files if required.

Interesting points:
- All the data combinations of pizza ordering can be done in a single scenario. However, multiple features are scenarios are created for reporting purpose.
- Cross browser testing is enabled so tests will run on multiple browsers.
- Automation report has screenshots attached for failed steps. However, if required screenshots can be enabled after every step irrespective of the execution status(Pass/Fail)
- With Junit 5 and cucumber parallel execution of tests can also be achived. Parallel execution would reduce the execution time to a greater extent.


  
