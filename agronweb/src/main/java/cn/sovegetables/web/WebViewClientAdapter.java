package cn.sovegetables.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;


/**
 * WebViewClientAdapter是WebViewClient的适配器, WebViewClient部分方法会有默认的实现，
 * WebViewClientAdapter重写WebViewClient所有的方法，不会调用方法的super
 */

public abstract class WebViewClientAdapter extends WebViewClient implements WebAttach, WebResulter, WebDetach{

    public WebViewClientAdapter() {
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
     * Give the host application a chance to take over the control when a new
     * url is about to be loaded in the current WebView. If WebViewClient is not
     * provided, by default WebView will ask Activity Manager to choose the
     * proper handler for the url. If WebViewClient is provided, return true
     * means the host application handles the url, while return false means the
     * current WebView handles the url.
     * This method is not called for requests using the POST "method".
     *
     * @param view The WebView that is initiating the callback.
     * @param url  The url to be loaded.
     * @return True if the host application wants to leave the current WebView
     * and handle the url itself, otherwise return false.
     * @deprecated Use {@link #shouldOverrideUrlLoading(WebView, WebResourceRequest)
     * shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead.
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    /**
     * Give the host application a chance to take over the control when a new
     * url is about to be loaded in the current WebView. If WebViewClient is not
     * provided, by default WebView will ask Activity Manager to choose the
     * proper handler for the url. If WebViewClient is provided, return true
     * means the host application handles the url, while return false means the
     * current WebView handles the url.
     *
     * <p>Notes:
     * <ul>
     * <li>This method is not called for requests using the POST &quot;method&quot;.</li>
     * <li>This method is also called for subframes with non-http schemes, thus it is
     * strongly disadvised to unconditionally call {@link WebView#loadUrl(String)}
     * with the request's url from inside the method and then return true,
     * as this will make WebView to attempt loading a non-http url, and thus fail.</li>
     * </ul>
     * </p>
     *
     * @param view    The WebView that is initiating the callback.
     * @param request Object containing the details of the request.
     * @return True if the host application wants to leave the current WebView
     * and handle the url itself, otherwise return false.
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }

    /**
     * Notify the host application that a page has started loading. This method
     * is called once for each main frame load so a page with iframes or
     * framesets will call onPageStarted one time for the main frame. This also
     * means that onPageStarted will not be called when the contents of an
     * embedded frame changes, i.e. clicking a link whose target is an iframe,
     * it will also not be called for fragment navigations (navigations to
     * #fragment_id).
     *
     * @param view    The WebView that is initiating the callback.
     * @param url     The url to be loaded.
     * @param favicon The favicon for this page if it already exists in the
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    /**
     * Notify the host application that a page has finished loading. This method
     * is called only for main frame. When onPageFinished() is called, the
     * rendering picture may not be updated yet. To get the notification for the
     * new Picture, use {@link WebView.PictureListener#onNewPicture}.
     *
     * @param view The WebView that is initiating the callback.
     * @param url  The url of the page.
     */
    @Override
    public void onPageFinished(WebView view, String url) {
    }

    /**
     * Notify the host application that the WebView will load the resource
     * specified by the given url.
     *
     * @param view The WebView that is initiating the callback.
     * @param url  The url of the resource the WebView will load.
     */
    @Override
    public void onLoadResource(WebView view, String url) {
    }

    /**
     * Notify the host application that {@link WebView} content left over from
     * previous page navigations will no longer be drawn.
     *
     * <p>This callback can be used to determine the point at which it is safe to make a recycled
     * {@link WebView} visible, ensuring that no stale content is shown. It is called
     * at the earliest point at which it can be guaranteed that {@link WebView#onDraw} will no
     * longer draw any content from previous navigations. The next draw will display either the
     * {@link WebView#setBackgroundColor background color} of the {@link WebView}, or some of the
     * contents of the newly loaded page.
     *
     * <p>This method is called when the body of the HTTP response has started loading, is reflected
     * in the DOM, and will be visible in subsequent draws. This callback occurs early in the
     * document loading process, and as such you should expect that linked resources (for example,
     * css and images) may not be available.</p>
     *
     * <p>For more fine-grained notification of visual state updates, see {@link
     * WebView#postVisualStateCallback}.</p>
     *
     * <p>Please note that all the conditions and recommendations applicable to
     * {@link WebView#postVisualStateCallback} also apply to this API.<p>
     *
     * <p>This callback is only called for main frame navigations.</p>
     *
     * @param view The {@link WebView} for which the navigation occurred.
     * @param url  The URL corresponding to the page navigation that triggered this callback.
     */
    @Override
    public void onPageCommitVisible(WebView view, String url) {
    }

    /**
     * Notify the host application of a resource request and allow the
     * application to return the data.  If the return value is null, the WebView
     * will continue to load the resource as usual.  Otherwise, the return
     * response and data will be used.  NOTE: This method is called on a thread
     * other than the UI thread so clients should exercise caution
     * when accessing private data or the view system.
     *
     * <p>Note: when Safe Browsing is enabled, these URLs still undergo Safe Browsing checks. If
     * this is undesired, whitelist the URL with {@link WebView#setSafeBrowsingWhitelist} or ignore
     * the warning with {@link #onSafeBrowsingHit}.
     *
     * @param view The {@link WebView} that is requesting the
     *             resource.
     * @param url  The raw url of the resource.
     * @return A {@link WebResourceResponse} containing the
     * response information or null if the WebView should load the
     * resource itself.
     * @deprecated Use {@link #shouldInterceptRequest(WebView, WebResourceRequest)
     * shouldInterceptRequest(WebView, WebResourceRequest)} instead.
     */
    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        return null;
    }

    /**
     * Notify the host application of a resource request and allow the
     * application to return the data.  If the return value is null, the WebView
     * will continue to load the resource as usual.  Otherwise, the return
     * response and data will be used.  NOTE: This method is called on a thread
     * other than the UI thread so clients should exercise caution
     * when accessing private data or the view system.
     *
     * <p>Note: when Safe Browsing is enabled, these URLs still undergo Safe Browsing checks. If
     * this is undesired, whitelist the URL with {@link WebView#setSafeBrowsingWhitelist} or ignore
     * the warning with {@link #onSafeBrowsingHit}.
     *
     * @param view    The {@link WebView} that is requesting the
     *                resource.
     * @param request Object containing the details of the request.
     * @return A {@link WebResourceResponse} containing the
     * response information or null if the WebView should load the
     * resource itself.
     */
    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return null;
    }

    /**
     * Notify the host application that there have been an excessive number of
     * HTTP redirects. As the host application if it would like to continue
     * trying to load the resource. The default behavior is to send the cancel
     * message.
     *
     * @param view        The WebView that is initiating the callback.
     * @param cancelMsg   The message to send if the host wants to cancel
     * @param continueMsg The message to send if the host wants to continue
     * @deprecated This method is no longer called. When the WebView encounters
     * a redirect loop, it will cancel the load.
     */
    @Override
    public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
    }

    /**
     * Report an error to the host application. These errors are unrecoverable
     * (i.e. the main resource is unavailable). The errorCode parameter
     * corresponds to one of the ERROR_* constants.
     *
     * @param view        The WebView that is initiating the callback.
     * @param errorCode   The error code corresponding to an ERROR_* value.
     * @param description A String describing the error.
     * @param failingUrl  The url that failed to load.
     * @deprecated Use {@link #onReceivedError(WebView, WebResourceRequest, WebResourceError)
     * onReceivedError(WebView, WebResourceRequest, WebResourceError)} instead.
     */
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
    }

    /**
     * Report web resource loading error to the host application. These errors usually indicate
     * inability to connect to the server. Note that unlike the deprecated version of the callback,
     * the new version will be called for any resource (iframe, image, etc), not just for the main
     * page. Thus, it is recommended to perform minimum required work in this callback.
     *
     * @param view    The WebView that is initiating the callback.
     * @param request The originating request.
     * @param error   Information about the error occured.
     */
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
    }

    /**
     * Notify the host application that an HTTP error has been received from the server while
     * loading a resource.  HTTP errors have status codes &gt;= 400.  This callback will be called
     * for any resource (iframe, image, etc), not just for the main page. Thus, it is recommended to
     * perform minimum required work in this callback. Note that the content of the server
     * response may not be provided within the <b>errorResponse</b> parameter.
     *
     * @param view          The WebView that is initiating the callback.
     * @param request       The originating request.
     * @param errorResponse Information about the error occured.
     */
    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
    }

    /**
     * As the host application if the browser should resend data as the
     * requested page was a result of a POST. The default is to not resend the
     * data.
     *
     * @param view       The WebView that is initiating the callback.
     * @param dontResend The message to send if the browser should not resend
     * @param resend     The message to send if the browser should resend data
     */
    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
    }

    /**
     * Notify the host application to update its visited links database.
     *
     * @param view     The WebView that is initiating the callback.
     * @param url      The url being visited.
     * @param isReload True if this url is being reloaded.
     */
    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
    }

    /**
     * Notify the host application that an SSL error occurred while loading a
     * resource. The host application must call either handler.cancel() or
     * handler.proceed(). Note that the decision may be retained for use in
     * response to future SSL errors. The default behavior is to cancel the
     * load.
     *
     * @param view    The WebView that is initiating the callback.
     * @param handler An SslErrorHandler object that will handle the user's
     *                response.
     * @param error   The SSL error object.
     */
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
    }

    /**
     * Notify the host application to handle a SSL client certificate
     * request. The host application is responsible for showing the UI
     * if desired and providing the keys. There are three ways to
     * respond: proceed(), cancel() or ignore(). Webview stores the response
     * in memory (for the life of the application) if proceed() or cancel() is
     * called and does not call onReceivedClientCertRequest() again for the
     * same host and port pair. Webview does not store the response if ignore()
     * is called. Note that, multiple layers in chromium network stack might be
     * caching the responses, so the behavior for ignore is only a best case
     * effort.
     * <p>
     * This method is called on the UI thread. During the callback, the
     * connection is suspended.
     * <p>
     * For most use cases, the application program should implement the
     * {@link KeyChainAliasCallback} interface and pass it to
     * {@link KeyChain#choosePrivateKeyAlias} to start an
     * activity for the user to choose the proper alias. The keychain activity will
     * provide the alias through the callback method in the implemented interface. Next
     * the application should create an async task to call
     * {@link KeyChain#getPrivateKey} to receive the key.
     * <p>
     * An example implementation of client certificates can be seen at
     * <A href="https://android.googlesource.com/platform/packages/apps/Browser/+/android-5.1.1_r1/src/com/android/browser/Tab.java">
     * AOSP Browser</a>
     * <p>
     * The default behavior is to cancel, returning no client certificate.
     *
     * @param view    The WebView that is initiating the callback
     * @param request An instance of a {@link ClientCertRequest}
     */
    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
    }

    /**
     * Notifies the host application that the WebView received an HTTP
     * authentication request. The host application can use the supplied
     * {@link HttpAuthHandler} to set the WebView's response to the request.
     * The default behavior is to cancel the request.
     *
     * @param view    the WebView that is initiating the callback
     * @param handler the HttpAuthHandler used to set the WebView's response
     * @param host    the host requiring authentication
     * @param realm   the realm for which authentication is required
     * @see WebView#getHttpAuthUsernamePassword
     */
    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
    }

    /**
     * Give the host application a chance to handle the key event synchronously.
     * e.g. menu shortcut key events need to be filtered this way. If return
     * true, WebView will not handle the key event. If return false, WebView
     * will always handle the key event, so none of the super in the view chain
     * will see the key event. The default behavior returns false.
     *
     * @param view  The WebView that is initiating the callback.
     * @param event The key event.
     * @return True if the host application wants to handle the key event
     * itself, otherwise return false
     */
    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return false;
    }

    /**
     * Notify the host application that a key was not handled by the WebView.
     * Except system keys, WebView always consumes the keys in the normal flow
     * or if shouldOverrideKeyEvent returns true. This is called asynchronously
     * from where the key is dispatched. It gives the host application a chance
     * to handle the unhandled key events.
     *
     * @param view  The WebView that is initiating the callback.
     * @param event The key event.
     */
    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
    }

    /**
     * Notify the host application that the scale applied to the WebView has
     * changed.
     *
     * @param view     The WebView that is initiating the callback.
     * @param oldScale The old scale factor
     * @param newScale The new scale factor
     */
    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
    }

    /**
     * Notify the host application that a request to automatically log in the
     * user has been processed.
     *
     * @param view    The WebView requesting the login.
     * @param realm   The account realm used to look up accounts.
     * @param account An optional account. If not null, the account should be
     *                checked against accounts on the device. If it is a valid
     *                account, it should be used to log in the user.
     * @param args    Authenticator specific arguments used to log in the user.
     */
    @Override
    public void onReceivedLoginRequest(WebView view, String realm, @Nullable String account, String args) {
    }

    /**
     * Notify host application that the given webview's render process has exited.
     * <p>
     * Multiple WebView instances may be associated with a single render process;
     * onRenderProcessGone will be called for each WebView that was affected.
     * The application's implementation of this callback should only attempt to
     * clean up the specific WebView given as a parameter, and should not assume
     * that other WebView instances are affected.
     * <p>
     * The given WebView can't be used, and should be removed from the view hierarchy,
     * all references to it should be cleaned up, e.g any references in the Activity
     * or other classes saved using findViewById and similar calls, etc
     * <p>
     * To cause an render process crash for test purpose, the application can
     * call loadUrl("chrome://crash") on the WebView. Note that multiple WebView
     * instances may be affected if they share a render process, not just the
     * specific WebView which loaded chrome://crash.
     *
     * @param view   The WebView which needs to be cleaned up.
     * @param detail the reason why it exited.
     * @return true if the host application handled the situation that process has
     * exited, otherwise, application will crash if render process crashed,
     * or be killed if render process was killed by the system.
     */
    @Override
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        return false;
    }

    /**
     * Notify the host application that a loading URL has been flagged by Safe Browsing.
     * <p>
     * The application must invoke the callback to indicate the preferred response. The default
     * behavior is to show an interstitial to the user, with the reporting checkbox visible.
     * <p>
     * If the application needs to show its own custom interstitial UI, the callback can be invoked
     * asynchronously with backToSafety() or proceed(), depending on user response.
     *
     * @param view       The WebView that hit the malicious resource.
     * @param request    Object containing the details of the request.
     * @param threatType The reason the resource was caught by Safe Browsing, corresponding to a
     *                   SAFE_BROWSING_THREAT_* value.
     * @param callback   Applications must invoke one of the callback methods.
     */
    @Override
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
    }
}
