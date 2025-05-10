run test:
  @echo 'Running {{test}}…'
  java -jar target/benchmarks.jar -rf json {{test}}
  mkdir -p results
  mv jmh-result.json results/jmh-result-{{test}}.json

clean:
  mvn clean

compile: clean
  mvn verify
