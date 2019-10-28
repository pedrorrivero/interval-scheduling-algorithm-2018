# INTERVAL SCHEDULING PROBLEM ON MULTIPLE RESOURCES

## README

  There are two different Java Projects located at `./Code/`:
  *"Project"* and *"Tests"*.

  The latter was developed in order to study the time complexity of the
  algorithm, and is simply a slight variation of the first one.
  It does not need input files as they are randomly generated to automate the
  testing process. The sourcecode lines for random generation of inputs are
  commented on the first project.

### DIRECTORY STRUCTURE

  Each project has its source files located at `**/src/` in the project
  directory. Inside there is a `Main.java` file and another directory named
  `Interval_Scheduling/`, which conforms a Java Package with its respective
  `.java` files.

  Similar directory structures can be found at `**/out/production/` inside each
  project's directory; this time containing the `.class` bytecode files from
  the Java compiler, which can be executed on the Java Virtual Machine.
  (Execute `Main.class`)

### EXECUTION

  To run the `Main.class` bytecode file from the first of the projects,
  the `input.txt` file must be at the location of execution and have its format
  according to the specifications from the statement (different formats are not
  guaranteed to give out the correct answer to the problem). It will return
  the `output.txt` filed required.

  The second project needs a directory `**/tmp/` at the location of execution
  to hold the temporary `input.txt` and 'output.txt' files randomly generated.
  It will return two files called *'nTest_m200.txt'* and *'mTest_n4000.txt'* with
  the results from the tests in line format **"n/m dimensionless_time"**.

## COMPILATION AND DEVELOPMENT

  The **IntelliJ** IDE was used for developing, debugging and compiling both
  projects. Plots were produced using **Matlab**. All software was
  used under student licenses.
