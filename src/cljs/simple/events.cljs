(ns simple.events
  (:require
   [re-frame.core :as re-frame]
   [simple.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 :update-count
 (fn [db [_ new-count]]
   (assoc db :count new-count)))

(re-frame/reg-event-db
 :update-todos
 (fn [db [_ new-todos]]
   (assoc db :todos new-todos)))

(defn update-todo-by-id
  "updates the todo with a given id"
  [todo id state]
  (if (= (:id todo) id)
    (assoc todo :state state)
    todo))

(re-frame/reg-event-db
 :update-todo-state
 (fn [db [_ [id state]]]
   (let [todos (:todos db)]
    (assoc db :todos (map (fn [t] (update-todo-by-id t id state)) todos)))))
