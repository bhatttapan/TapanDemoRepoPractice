set projectLocation=C:\TAPAN\STUDY\QUALITY ASSURANCE NIKUL SIR\Selenium_Workspace\PracticeBasicFramework3
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause