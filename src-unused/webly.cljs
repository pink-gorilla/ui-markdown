(ns unused.webly)

   [webly.user.markdown.subscriptions]
[webly.user.markdown.events]
[webly.user.markdown.page] ; reagent-page: md 


[:p [link-dispatch [:bidi/goto :ui/markdown :file "webly.md"] "webly docs"]]

     (dispatch [:markdown/init])
(dispatch [:markdown/load-index])