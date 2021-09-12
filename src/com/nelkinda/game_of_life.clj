(ns com.nelkinda.game-of-life)

(def rules {
    :survival #{2 3}
    :birth #{3}
})

(defn P [x y] {:x x :y y})
(defn neighbors [cell]
    (def neighbors-of-origin #{(P -1 -1) (P -1 0) (P -1 1) (P 0 -1) (P 0 1) (P 1 -1) (P 1 0) (P 1 1)})
    (defn plus [cell1 cell2] {:x (+ (:x cell1) (:x cell2)) :y (+ (:y cell1) (:y cell2))})

    (map #(plus cell %) neighbors-of-origin))

(defn next-generation [life]
    (defn is-alive [cell] (contains? life cell))
    (defn is-dead [cell] (not (is-alive cell)))
    (defn dead-neighbors [cell] (filter #(is-dead %) (neighbors cell)))
    (defn live-neighbors [cell] (filter #(is-alive %) (neighbors cell)))
    (defn count-live-neighbors [cell] (count (live-neighbors cell)))
    (defn born [cell rules] (contains? (:birth rules) (count-live-neighbors cell)))
    (defn survives [cell rules] (contains? (:survival rules) (count-live-neighbors cell)))
    (defn dead-neighbors-of-living-cells [] (mapcat #(dead-neighbors %) life))
    (defn surviving-cells [] (filter #(survives % rules) life))
    (defn born-cells [] (filter #(born % rules) (dead-neighbors-of-living-cells)))

    (into #{} (concat (surviving-cells) (born-cells))))
