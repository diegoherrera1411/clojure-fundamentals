(ns euler.even-fibonacci-sum)

(def fibonacci-sequence
  (->> [0 1]
       (iterate (fn [[fb-1 fb-2]]
                  [fb-2 (+ fb-1 fb-2)]))
       (map last)))

(defn sum-even-fibonacci-below [n]
  (let [filter-even-less-than-n (comp
                                  (take-while #(<= % n))
                                  (filter even?))]
    (transduce filter-even-less-than-n + fibonacci-sequence)))
