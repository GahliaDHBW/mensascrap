(ns mensascrap.core
  (:require [cheshire.core :refer :all])
  (:require [clj-http.client :as client])
  (:require [hickory.core :refer :all])
)

(def raw (->> "sample.html"
              (#(slurp %))
              (#(parse %))
              (#(as-hiccup %))
))
(def bone (->> raw
               (#(second %))
               (#(get % 3))
               (#(get % 5))
               (#(get % 2))
               (#(get % 3))
               (#(get % 3))
))
(def whale (->> bone
                (#(get % 3)) ;;meal: 3 -> Wahlessen 1, 5 -> Wahlessen 2, 7 -> Wahlessen 3
                (#(get % 2)) ;;day: 2-6 maps to mon-fri
                (#(get % 2))
))
(def meals [3 5 7])
(def days [2 3 4 5 6])

(defn fishknife
  [largefish]
  (def a (->> largefish
       (#(get % 2))
       (#(get % 2))
       (#(get % 2))))
  (def b (->> largefish
       (#(get % 3))
       (#(get % 2))
       (#(get % 2))))
  [a b]
)
(fishknife whale)
