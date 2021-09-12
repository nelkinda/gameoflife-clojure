(ns com.nelkinda.game-of-life-test
    (:require
        [clojure.test :refer :all]
        [com.nelkinda.game-of-life :refer :all]
        [clojure.set :as set]
    )
    (:use
        [clojure.test]
    )
)

(deftest a-test
    (testing "Creation of a Point."
        (is (= (P 0 1) (P 0 1)))
        (is (= (P 0 1) (P 1 0)))
        (is (= (P 2 3) (plus (P 1 2) (P 1 1))))
    )
)

(deftest test-cells
    (testing "Cell functions."
        ;;(is (isAlive #{(P 0 0)} (P 0 0)))
        ;;(is (= #{(P -1 -1) (P -1 0) (P -1 1) (P 0 -1) (P 0 1) (P 1 -1) (P 1 0) (P 1 1)} (neighbors (P 0 0))))
    )
)

(deftest test-universe-cells
    (testing "Universe Cell functions."
        ;;(is (= #{(P -1 -1) (P -1 0) (P -1 1) (P 0 -1) (P 0 1) (P 1 -1) (P 1 0) (P 1 1)} (deadNeighbors #{(P 0 0)} (P 0 0))))
        ;;(is (= #{(P -1 -1) (P -1 0) (P -1 1) (P 0 -1) (P 0 1) (P 1 -1) (P 1 0)} (deadNeighbors #{(P 0 0) (P 1 1)} (P 0 0))))
        ;;(is (= #{} (liveNeighbors #{(P 0 0)} (P 0 0))))
        ;;(is (= #{(P 1 1)} (liveNeighbors #{(P 0 0) (P 1 1)} (P 0 0))))
    )
)

(deftest test-universe
    (testing "An empty universe remains empty."
        (is (= #{} #{}))
        (is (= #{} (set/union #{} #{})))
        (is (= #{} (next-generation #{})))
    )
)

(deftest test-blinker
    (testing "Blinker"
        (is (= #{(P -1 0) (P 0 0) (P 1 0)} (next-generation #{(P 0 -1) (P 0 0) (P 0 1)})))
        (is (= #{(P 0 -1) (P 0 0) (P 0 1)} (next-generation (next-generation #{(P 0 -1) (P 0 0) (P 0 1)}))))
    )
)

(defn parse-simplified-life-1_05 [spec] #{})

(deftest test-parse-simplified-life-1_05
    (testing "parse simplified Life 1.05"
        (is (= #{} (parse-simplified-life-1_05 "")))
    )
)
