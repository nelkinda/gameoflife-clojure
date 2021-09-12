(ns gameoflife.test.core
    (:use [com.nelkinda.game-of-life])
    (:use [clojure.test])
    (:use [leiningen.cucumber])
    (:import [cucumber.api.cli Main])
)

(deftest a-test
    (testing "something"
        (is (= (P 0 1) (P 0 1)))
    )
)

(deftest run-cukes
    (. cucumber.api.cli.Main (main (into-array ["--format" "pretty" "--glue" "test" "test/features"]))))
