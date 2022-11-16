(ns mensascrap.core
  (:require [cheshire.core :refer :all])
  (:require [clj-http.client :as client])
  (:require [hickory.core :refer :all])
)

(def raw (slurp "sample.html"))
(as-hickory (parse raw))
(as-hiccup (parse raw))
