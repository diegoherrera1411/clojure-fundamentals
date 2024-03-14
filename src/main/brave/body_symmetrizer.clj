(ns brave.body-symmetrizer
  (:require
    [clojure.string :as string]))

(defn n->pattern [n]
  (str n "-"))

(defn symmetric-part-from-number+part [{:keys [name size]} n]
  {:name (string/replace name #"^1-" (n->pattern n))
   :size size})

(defn symmetric-parts [num-parts-to-generate part]
  (let [matching-parts (->> (range 2 (inc num-parts-to-generate))
                            (map (partial symmetric-part-from-number+part part)))]
    (set (conj matching-parts part))))

(defn symmetric-body [num-parts-to-generate parts]
  (reduce
    #(into %1 (symmetric-parts num-parts-to-generate %2))
    []
    parts))
