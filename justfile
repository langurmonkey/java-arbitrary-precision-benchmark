run test:
  @echo 'Running {{test}}…'
  java -jar target/benchmarks.jar {{test}}

clean:
  mvn clean

compile: clean
  mvn verify
