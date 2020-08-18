(ns simple.db)

(def default-db
  {:name "re-frame"
   :count 0
   :todos [
            {:id 1 :text "learn reframe" :state "todo"}
            {:id 2 :text "learn reagent" :state "todo"}
            {:id 3 :text "learn hiccup" :state "todo"}
            ]})
