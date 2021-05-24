(ns ui.markdown.goldly.prosemirror-atom
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]
   [ui.markdown.goldly.prosemirror-themed :refer [prosemirror-themed]]))

(defn prosemirror-atom [id a path]
  (let [active? true
        get-data (fn [_] ; id
                   (if path
                     (get-in @a path)
                     @a))
        save-data (fn [_ text] ; id
                    (info "pm-text save")
                    (if path
                      (swap! a assoc-in path text)
                      (reset! a text)))
        fun {:get-data get-data
             :save-data save-data}]

    [prosemirror-themed id fun active?]))