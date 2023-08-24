# Alina_Rubcova_TDL_SS_Final_Task

Maven Commands and Explanations
---------------------------------------------------------------------------------------
<h3>6.1. Run One Specific Test Class
To run a specific test class using Maven, you can use the following command:</h3>

`mvn test -Dtest=TestClass`

<small>Replace TestClass with the name of the test class you want to run. This command triggers the test phase and runs only the tests in the specified class.</small>

---------------------------------------------------------------------------------------
<h3>6.2. Run One Specific Test in Class
If you want to run only one specific test method from a test class, you can use the following command:</h3>

`mvn test -Dtest=TestClass#testMethod`

<small>Replace TestClass with the name of the test class and testMethod with the name of the test method you want to run. This command executes only the specified test method. </small>

---------------------------------------------------------------------------------------
<h3>6.3. Run All 'Regression Tests'
Running tests with specific groups, such as 'Regression Tests,' can be achieved using the groups parameter. In your test class, you can annotate tests with @Test(groups = "Regression"). Then, you can run these tests using the following command:</h3>

`mvn test -Dgroups=Regression`

<small>Replace Regression with the desired group name. Maven will execute all tests annotated with that group.</small>

---------------------------------------------------------------------------------------
<h3>6.4. Exclude Tests from Execution
There are multiple ways to exclude tests from execution in Maven:</h3>

<small>1.Using -Dtest Parameter:
You can exclude specific tests by using the -Dtest parameter with the ! symbol. For example, to exclude TestToExclude class, use:</small>

`mvn test -Dtest=!TestToExclude`

<br/><br/>
<small>2.Exclusion Filters in pom.xml:
You can configure exclusion filters in your pom.xml:</small>

`<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>**/TestToExclude.java</exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>`

<br/><br/>
<small>3.TestNG XML Suite:
Create a TestNG XML suite file where you specify the tests to be excluded:</small>

`<suite name="MySuite">
    <test name="Regression">
        <classes>
            <class name="com.example.TestClass1"/>
        </classes>
        <methods>
            <exclude name="testToExclude"/>
        </methods>
    </test>
</suite>`

<small>Then, execute the suite using the surefire plugin:</small>

`mvn test -DsuiteXmlFile=testng.xml`

