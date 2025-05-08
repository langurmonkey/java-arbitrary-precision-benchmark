run test:
  @echo 'Running {{test}}…'
  java -jar target/benchmarks.jar -rf json {{test}}
  mv jmh-result.json results/jmh-result-{{test}}.json

clean:
  mvn clean

compile: clean
  mvn verify
