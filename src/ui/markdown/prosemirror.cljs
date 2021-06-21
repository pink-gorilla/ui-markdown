(ns ui.markdown.prosemirror
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof warn error]]
   [reagent.core :as r]
   [reagent.dom :as rd]
   [re-frame.core :as rf]
   ["prosemirror-model" :refer [Schema DOMParser]]
   ["prosemirror-state" :refer [EditorState]]
   ["prosemirror-view" :refer [EditorView]]
   ["prosemirror-commands" :refer [toggleMark]]
   ;["prosemirror-schema-basic" :refer [schema]]
   ;["prosemirror-schema-list" :refer [addListNodes]]
   ["prosemirror-example-setup" :refer [exampleSetup]]
   ["prosemirror-markdown" :refer [schema defaultMarkdownParser defaultMarkdownSerializer]]
   [ui.editor.base :refer [make-editor]]))

; https://prosemirror.net/examples/markdown/

(defn editor-content [editor]
  (.serialize
   defaultMarkdownSerializer
   (.. editor -state -doc)))

(defn on-trans [save-data id editor t]
  (let [new-state (.. editor -state (apply t))]
    (. editor (updateState new-state))
    (save-data id (editor-content editor))))

(defn create-state [content]
  (let [state  (.create
                EditorState
                #js {:doc (.parse defaultMarkdownParser content)
                     :plugins (exampleSetup #js {:schema schema})})]
    state))

(defn editor-create [save-data id node content]
  (let [editor (EditorView.
                node
                #js {:state (create-state content)})]
    (. editor (setProps
               #js {:dispatchTransaction (partial on-trans save-data id editor)}))
    editor))

(defn editor-destroy [editor]
  (.destroy editor))

(defn editor-focus [editor]
  (.focus editor))

(defn editor-blur [editor]
  (.blur editor))

(defn editor-load-content [editor content]
  (let [doc (.parse defaultMarkdownParser content)]
    (set! (.. editor -state -doc) doc)))

;(defn mark-active [state type]
;  (let [from (.. state -selection -from)
;        $from (.. state -selection -$from)
;        to (.. state -selection -to)
;        empty (.. state -selection -empty)]
;    if (empty) 
;    type.isInSet (state.storedMarks || $from.marks ())
;     (.. state -doc (rangeHasMark from to type))

; (markActive(state, markType)) {
;        toggleMark(markType)(state, dispatch)

#_(defn header-icon [fa-icon mark] ; rf-dispatch
    [:a {:on-click #(rf/dispatch rf-dispatch)
         :class "hover:text-blue-700 mr-1"}
     [:i {:class (str "fa-lg pl-1 " fa-icon)}]])

#_(defn pm-menu [editor]
    [header-icon "fa fa-question-circle" (.. schema -marks -strong)])

(defn prosemirror-reagent [id {:keys [get-data save-data] :as fun} active?]
  (let [editor (make-editor
                {:get-data get-data
    ;:set-data set-data
                 :editor-load-content editor-load-content
                 :editor-focus editor-focus
                 :editor-destroy editor-destroy
                 :editor-create (partial editor-create save-data)})]
    (fn [id {:keys [get-data save-data] :as fun} active?]
      [:div.prose
       [editor id active?]])))