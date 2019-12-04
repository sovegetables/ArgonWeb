package cn.sovegetables.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

import androidx.annotation.Nullable;

/**
 * WebChromeClientAdapter是WebChromeClient的适配器, WebChromeClient部分方法会有默认的实现，
 * WebChromeClientAdapter重写WebChromeClient所有的方法，不会调用方法的super
 */

public abstract class WebChromeClientAdapter extends WebChromeClient implements WebAttach, WebResulter, WebDetach {

    public WebChromeClientAdapter() {
        super();
    }

    @Override
    public void attachWeb(WebView webView, Activity activity) {
    }

    public void detachWeb(WebView webView, Activity activity){
    }

    public void onActivityResult(Activity activity, int reqeustCode, int resultCode, Intent data){
    }

    /**
     * Tell the host application the current progress of loading a page.
     *
     * @param view        The WebView that initiated the callback.
     * @param newProgress Current page loading progress, represented by
     */
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
    }

    /**
     * Notify the host application of a change in the document title.
     *
     * @param view  The WebView that initiated the callback.
     * @param title A String containing the new title of the document.
     */
    @Override
    public void onReceivedTitle(WebView view, String title) {
    }

    /**
     * Notify the host application of a new favicon for the current page.
     *
     * @param view The WebView that initiated the callback.
     * @param icon A Bitmap containing the favicon for the current page.
     */
    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
    }

    /**
     * Notify the host application of the url for an apple-touch-icon.
     *
     * @param view        The WebView that initiated the callback.
     * @param url         The icon url.
     * @param precomposed True if the url is for a precomposed touch icon.
     */
    @Override
    public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
    }

    /**
     * Notify the host application that the current page has entered full
     * screen mode. The host application must show the custom View which
     * contains the web contents &mdash; video or other HTML content &mdash;
     * in full screen mode. Also see "Full screen support" documentation on
     * {@link WebView}.
     *
     * @param view     is the View object to be shown.
     * @param callback invoke this callback to request the page to exit
     */
    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
    }

    /**
     * Notify the host application that the current page would
     * like to show a custom View in a particular orientation.
     *
     * @param view                 is the View object to be shown.
     * @param requestedOrientation An orientation constant as used in
     *                             {@link ActivityInfo#screenOrientation ActivityInfo.screenOrientation}.
     * @param callback             is the callback to be invoked if and when the view
     *                             is dismissed.
     * @deprecated This method supports the obsolete plugin mechanism,
     * and will not be invoked in future
     */
    @Override
    public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
    }

    /**
     * Notify the host application that the current page has exited full
     * screen mode. The host application must hide the custom View, ie. the
     * View passed to {@link #onShowCustomView} when the content entered fullscreen.
     * Also see "Full screen support" documentation on {@link WebView}.
     */
    @Override
    public void onHideCustomView() {
    }

    /**
     * Request the host application to create a new window. If the host
     * application chooses to honor this request, it should return true from
     * this method, create a new WebView to host the window, insert it into the
     * View system and send the supplied resultMsg message to its target with
     * the new WebView as an argument. If the host application chooses not to
     * honor the request, it should return false from this method. The default
     * implementation of this method does nothing and hence returns false.
     *
     * @param view          The WebView from which the request for a new window
     *                      originated.
     * @param isDialog      True if the new window should be a dialog, rather than
     *                      a full-size window.
     * @param isUserGesture True if the request was initiated by a user gesture,
     *                      such as the user clicking a link.
     * @param resultMsg     The message to send when once a new WebView has been
     *                      created. resultMsg.obj is a
     *                      {@link WebView.WebViewTransport} object. This should be
     *                      used to transport the new WebView, by calling
     *                      {@link WebView.WebViewTransport#setWebView(WebView)
     *                      WebView.WebViewTransport.setWebView(WebView)}.
     * @return This method should return true if the host application will
     * create a new window, in which case resultMsg should be sent to
     * its target. Otherwise, this method should return false. Returning
     * false from this method but also sending resultMsg will result in
     * undefined behavior.
     */
    @Override
    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        return false;
    }

    /**
     * Request display and focus for this WebView. This may happen due to
     * another WebView opening a link in this WebView and requesting that this
     * WebView be displayed.
     *
     * @param view The WebView that needs to be focused.
     */
    @Override
    public void onRequestFocus(WebView view) {
    }

    /**
     * Notify the host application to close the given WebView and remove it
     * from the view system if necessary. At this point, WebCore has stopped
     * any loading in this window and has removed any cross-scripting ability
     * in javascript.
     *
     * @param window The WebView that needs to be closed.
     */
    @Override
    public void onCloseWindow(WebView window) {
    }

    /**
     * Tell the client to display a javascript alert dialog.  If the client
     * returns true, WebView will assume that the client will handle the
     * dialog.  If the client returns false, it will continue execution.
     *
     * @param view    The WebView that initiated the callback.
     * @param url     The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param result  A JsResult to confirm that the user hit enter.
     * @return boolean Whether the client will handle the alert dialog.
     */
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return false;
    }

    /**
     * Tell the client to display a confirm dialog to the user. If the client
     * returns true, WebView will assume that the client will handle the
     * confirm dialog and call the appropriate JsResult method. If the
     * client returns false, a default value of false will be returned to
     * javascript. The default behavior is to return false.
     *
     * @param view    The WebView that initiated the callback.
     * @param url     The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param result  A JsResult used to send the user's response to
     *                javascript.
     * @return boolean Whether the client will handle the confirm dialog.
     */
    @Override
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        return false;
    }

    /**
     * Tell the client to display a prompt dialog to the user. If the client
     * returns true, WebView will assume that the client will handle the
     * prompt dialog and call the appropriate JsPromptResult method. If the
     * client returns false, a default value of false will be returned to to
     * javascript. The default behavior is to return false.
     *
     * @param view         The WebView that initiated the callback.
     * @param url          The url of the page requesting the dialog.
     * @param message      Message to be displayed in the window.
     * @param defaultValue The default value displayed in the prompt dialog.
     * @param result       A JsPromptResult used to send the user's reponse to
     *                     javascript.
     * @return boolean Whether the client will handle the prompt dialog.
     */
    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        return false;
    }

    /**
     * Tell the client to display a dialog to confirm navigation away from the
     * current page. This is the result of the onbeforeunload javascript event.
     * If the client returns true, WebView will assume that the client will
     * handle the confirm dialog and call the appropriate JsResult method. If
     * the client returns false, a default value of true will be returned to
     * javascript to accept navigation away from the current page. The default
     * behavior is to return false. Setting the JsResult to true will navigate
     * away from the current page, false will cancel the navigation.
     *
     * @param view    The WebView that initiated the callback.
     * @param url     The url of the page requesting the dialog.
     * @param message Message to be displayed in the window.
     * @param result  A JsResult used to send the user's response to
     *                javascript.
     * @return boolean Whether the client will handle the confirm dialog.
     */
    @Override
    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        return false;
    }

    /**
     * Tell the client that the quota has been exceeded for the Web SQL Database
     * API for a particular origin and request a new quota. The client must
     * respond by invoking the
     * {@link WebStorage.QuotaUpdater#updateQuota(long) updateQuota(long)}
     * method of the supplied {@link WebStorage.QuotaUpdater} instance. The
     * minimum value that can be set for the new quota is the current quota. The
     * default implementation responds with the current quota, so the quota will
     * not be increased.
     *
     * @param url                   The URL of the page that triggered the notification
     * @param databaseIdentifier    The identifier of the database where the quota
     *                              was exceeded.
     * @param quota                 The quota for the origin, in bytes
     * @param estimatedDatabaseSize The estimated size of the offending
     *                              database, in bytes
     * @param totalQuota            The total quota for all origins, in bytes
     * @param quotaUpdater          An instance of {@link WebStorage.QuotaUpdater} which
     *                              must be used to inform the WebView of the new quota.
     * @deprecated This method is no longer called; WebView now uses the HTML5 / JavaScript Quota
     * Management API.
     */
    @Override
    public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
    }

    /**
     * Notify the host application that the Application Cache has reached the
     * maximum size. The client must respond by invoking the
     * {@link WebStorage.QuotaUpdater#updateQuota(long) updateQuota(long)}
     * method of the supplied {@link WebStorage.QuotaUpdater} instance. The
     * minimum value that can be set for the new quota is the current quota. The
     * default implementation responds with the current quota, so the quota will
     * not be increased.
     *
     * @param requiredStorage The amount of storage required by the Application
     *                        Cache operation that triggered this notification,
     *                        in bytes.
     * @param quota           the current maximum Application Cache size, in bytes
     * @param quotaUpdater    An instance of {@link WebStorage.QuotaUpdater} which
     *                        must be used to inform the WebView of the new quota.
     * @deprecated This method is no longer called; WebView now uses the HTML5 / JavaScript Quota
     * Management API.
     */
    @Override
    public void onReachedMaxAppCacheSize(long requiredStorage, long quota, WebStorage.QuotaUpdater quotaUpdater) {
    }

    /**
     * Notify the host application that web content from the specified origin
     * is attempting to use the Geolocation API, but no permission state is
     * currently set for that origin. The host application should invoke the
     * specified callback with the desired permission state. See
     * {@link GeolocationPermissions} for details.
     *
     * <p>Note that for applications targeting Android N and later SDKs
     * (API level > {@link Build.VERSION_CODES#M})
     * this method is only called for requests originating from secure
     * origins such as https. On non-secure origins geolocation requests
     * are automatically denied.</p>
     *
     * @param origin   The origin of the web content attempting to use the
     *                 Geolocation API.
     * @param callback The callback to use to set the permission state for the
     */
    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
    }

    /**
     * Notify the host application that a request for Geolocation permissions,
     * made with a previous call to
     * {@link #onGeolocationPermissionsShowPrompt(String, GeolocationPermissions.Callback) onGeolocationPermissionsShowPrompt()}
     * has been canceled. Any related UI should therefore be hidden.
     */
    @Override
    public void onGeolocationPermissionsHidePrompt() {
    }

    /**
     * Notify the host application that web content is requesting permission to
     * access the specified resources and the permission currently isn't granted
     * or denied. The host application must invoke {@link PermissionRequest#grant(String[])}
     * or {@link PermissionRequest#deny()}.
     * <p>
     * If this method isn't overridden, the permission is denied.
     *
     * @param request the PermissionRequest from current web content.
     */
    @Override
    public void onPermissionRequest(PermissionRequest request) {
    }

    /**
     * Notify the host application that the given permission request
     * has been canceled. Any related UI should therefore be hidden.
     *
     * @param request the PermissionRequest that needs be canceled.
     */
    @Override
    public void onPermissionRequestCanceled(PermissionRequest request) {
    }

    /**
     * Tell the client that a JavaScript execution timeout has occured. And the
     * client may decide whether or not to interrupt the execution. If the
     * client returns true, the JavaScript will be interrupted. If the client
     * returns false, the execution will continue. Note that in the case of
     * continuing execution, the timeout counter will be reset, and the callback
     * will continue to occur if the script does not finish at the next check
     * point.
     *
     * @return boolean Whether the JavaScript execution should be interrupted.
     * @deprecated This method is no longer supported and will not be invoked.
     */
    @Override
    public boolean onJsTimeout() {
        return false;
    }

    /**
     * Report a JavaScript error message to the host application. The ChromeClient
     * should override this to process the log message as they see fit.
     *
     * @param message    The error message to report.
     * @param lineNumber The line number of the error.
     * @param sourceID   The name of the source file that caused the error.
     * @deprecated Use {@link #onConsoleMessage(ConsoleMessage) onConsoleMessage(ConsoleMessage)}
     * instead.
     */
    @Override
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
    }

    /**
     * Report a JavaScript console message to the host application. The ChromeClient
     * should override this to process the log message as they see fit.
     *
     * @param consoleMessage Object containing details of the console message.
     * @return true if the message is handled by the client.
     */
    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    /**
     * When not playing, video elements are represented by a 'poster' image. The
     * image to use can be specified by the poster attribute of the video tag in
     * HTML. If the attribute is absent, then a default poster will be used. This
     * method allows the ChromeClient to provide that default image.
     *
     * @return Bitmap The image to use as a default poster, or null if no such image is
     * available.
     */
    @Nullable
    @Override
    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    /**
     * Obtains a View to be displayed while buffering of full screen video is taking
     * place. The host application can override this method to provide a View
     * containing a spinner or similar.
     *
     * @return View The View to be displayed whilst the video is loading.
     */
    @Nullable
    @Override
    public View getVideoLoadingProgressView() {
        return null;
    }

    /**
     * Obtains a list of all visited history items, used for link coloring
     *
     * @param callback
     */
    @Override
    public void getVisitedHistory(ValueCallback<String[]> callback) {
    }

    /**
     * Tell the client to show a file chooser.
     * <p>
     * This is called to handle HTML forms with 'file' input type, in response to the
     * user pressing the "Select File" button.
     * To cancel the request, call <code>filePathCallback.onReceiveValue(null)</code> and
     * return true.
     *
     * @param webView           The WebView instance that is initiating the request.
     * @param filePathCallback  Invoke this callback to supply the list of paths to files to upload,
     *                          or NULL to cancel. Must only be called if the
     *                          <code>showFileChooser</code> implementations returns true.
     * @param fileChooserParams Describes the mode of file chooser to be opened, and options to be
     *                          used with it.
     * @return true if filePathCallback will be invoked, false to use default handling.
     * @see FileChooserParams
     */
    @Override
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
        return false;
    }
}
