(use 'com.nelkinda.game-of-life)
(use 'clojure.test)

(def universe (atom #{}))

(defn parse
    ([spec] (into #{} (parse (clojure.string/split spec #"") 0 0 '())))
    ([spec x y set] (case (first spec)
        "." (parse (rest spec) (+ x 1) y set)
        "*" (parse (rest spec) (+ x 1) y (cons (P x y) set))
        "\n" (parse (rest spec) 0 (+ y 1) set)
        (nil "") set
        (throw (AssertionError. (str "Wrong input: '" (first spec) "'"))))))

(Given #"the following universe:" [spec]
    (reset! universe (parse spec)))

(Then #"the next generation MUST be:" [spec]
    (assert (= (reset! universe (next-generation @universe)) (parse spec))))
