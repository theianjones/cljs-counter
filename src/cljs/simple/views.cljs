(ns simple.views
  (:require
   [re-frame.core :as re-frame]
   [simple.subs :as subs]
   ))


(defn main-panel []
  (let [count (re-frame/subscribe [::subs/count])]
    [:div
     [:p @count]
     [:button
        {:on-click #(re-frame/dispatch [:update-count (inc @count)])}
      "+"]
     [:button
        {:on-click #(re-frame/dispatch [:update-count (dec @count)])}
        "-"]
     ]))
