(ns euler.sum-square-difference)

(def sum-square-diff
  (iterate (fn [[acc idx]]
             (let [new-idx  (inc idx)
                   idx-part (* idx (* new-idx new-idx))
                   new-acc  (+ acc idx-part)]
               [new-acc new-idx]))
           [0 1]))

(defn sum-square-diff-term [n]
  (-> (take n sum-square-diff) last first))

(comment
 (sum-square-diff-term 100))
