(ns simple.views
  (:require
   [re-frame.core :as re-frame]
   [simple.subs :as subs]
   ))

(def x (re-frame/subscribe [::subs/count]))

(defn counter []
   (let [count (re-frame/subscribe [::subs/count])]
    [:div
     [:p @count]
     [:button
        {:on-click #(re-frame/dispatch [:update-count (inc @count)])}
      "+"]
     [:button
        {:on-click #(re-frame/dispatch [:update-count (dec @count)])}
        "-"]
     ])
  )

(defn todo-item [item]
  [:li
   [:div {:on-click #(re-frame/dispatch [:update-todo-state [(:id item) (if (= (:state item) "todo") "done" "todo")]])}
    (:state item) " " (:text item)]
   ])

(def todos (re-frame/subscribe [::subs/todos]))

(defn todo []
  [:ul
   (map todo-item @todos)])

(defn main-panel []
  [:div
   [counter]
   [todo]
   ]
 )
