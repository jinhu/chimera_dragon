package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.p002c.C0033m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.apps.androidify.cm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.h */
public class C0011h extends Activity {
    final Handler f110a;
    final C0016n f111b;
    final C0007k f112c;
    boolean f113d;
    boolean f114e;
    boolean f115f;
    boolean f116g;
    boolean f117h;
    boolean f118i;
    boolean f119j;
    boolean f120k;
    C0033m f121l;
    C0026y f122m;

    private static String m92a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case cm.HListView_android_entries /*0*/:
                stringBuilder.append('V');
                break;
            case cm.HListView_hlv_footerDividersEnabled /*4*/:
                stringBuilder.append('I');
                break;
            case cm.ExpandableHListView_hlv_childIndicatorPaddingTop /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m93a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0011h.m92a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m93a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    C0026y m94a(String str, boolean z, boolean z2) {
        if (this.f121l == null) {
            this.f121l = new C0033m();
        }
        C0026y c0026y = (C0026y) this.f121l.get(str);
        if (c0026y != null) {
            c0026y.m182a(this);
            return c0026y;
        } else if (!z2) {
            return c0026y;
        } else {
            c0026y = new C0026y(str, this, z);
            this.f121l.put(str, c0026y);
            return c0026y;
        }
    }

    protected void m95a() {
        this.f111b.m160m();
    }

    public void m96a(Fragment fragment) {
    }

    void m97a(String str) {
        if (this.f121l != null) {
            C0026y c0026y = (C0026y) this.f121l.get(str);
            if (c0026y != null && !c0026y.f171g) {
                c0026y.m191h();
                this.f121l.remove(str);
            }
        }
    }

    void m98a(boolean z) {
        if (!this.f116g) {
            this.f116g = true;
            this.f117h = z;
            this.f110a.removeMessages(1);
            m102d();
        }
    }

    protected boolean m99a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public Object m100b() {
        return null;
    }

    public void m101c() {
        if (VERSION.SDK_INT >= 11) {
            C0002a.m68a(this);
        } else {
            this.f118i = true;
        }
    }

    void m102d() {
        if (this.f120k) {
            this.f120k = false;
            if (this.f122m != null) {
                if (this.f117h) {
                    this.f122m.m187d();
                } else {
                    this.f122m.m186c();
                }
            }
        }
        this.f111b.m163p();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f113d);
            printWriter.print("mResumed=");
            printWriter.print(this.f114e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f115f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f116g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f120k);
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f113d);
            printWriter.print("mResumed=");
            printWriter.print(this.f114e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f115f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f116g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.f120k);
        }
        if (this.f122m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f122m)));
            printWriter.println(":");
            this.f122m.m183a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f111b.m131a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m93a(str + "  ", printWriter, getWindow().getDecorView());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f111b.m156i();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.f111b.f138f == null || i3 < 0 || i3 >= this.f111b.f138f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f111b.f138f.get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.m16a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f111b.m145c()) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f111b.m122a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f111b.m129a(this, this.f112c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0013j c0013j = (C0013j) getLastNonConfigurationInstance();
        if (c0013j != null) {
            this.f121l = c0013j.f128e;
        }
        if (bundle != null) {
            this.f111b.m124a(bundle.getParcelable("android:support:fragments"), c0013j != null ? c0013j.f127d : null);
        }
        this.f111b.m157j();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.f111b.m134a(menu, getMenuInflater()) : true;
    }

    public View onCreateView(String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        int i = 0;
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(fragment, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0012i.f123a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.m13b((Context) this, attributeValue)) {
            return super.onCreateView(str, context, attributeSet);
        }
        if (fragment != null) {
            i = fragment.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f111b.m114a(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f111b.m116a(string);
        }
        if (fragment == null && i != -1) {
            fragment = this.f111b.m114a(i);
        }
        if (C0016n.f132a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragment);
        }
        if (fragment == null) {
            Fragment a = Fragment.m11a((Context) this, attributeValue);
            a.f47o = true;
            a.f55w = resourceId != 0 ? resourceId : i;
            a.f56x = i;
            a.f57y = string;
            a.f48p = true;
            a.f51s = this.f111b;
            a.m19a((Activity) this, attributeSet, a.f36d);
            this.f111b.m128a(a, true);
            fragment = a;
        } else if (fragment.f48p) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
        } else {
            fragment.f48p = true;
            if (!fragment.f20C) {
                fragment.m19a((Activity) this, attributeSet, fragment.f36d);
            }
            this.f111b.m137b(fragment);
        }
        if (fragment.f26I == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.f26I.setId(resourceId);
        }
        if (fragment.f26I.getTag() == null) {
            fragment.f26I.setTag(string);
        }
        return fragment.f26I;
    }

    protected void onDestroy() {
        super.onDestroy();
        m98a(false);
        this.f111b.m165r();
        if (this.f122m != null) {
            this.f122m.m191h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f111b.m166s();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case cm.HListView_android_entries /*0*/:
                return this.f111b.m135a(menuItem);
            case cm.HListView_hlv_overScrollFooter /*6*/:
                return this.f111b.m142b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f111b.m156i();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case cm.HListView_android_entries /*0*/:
                this.f111b.m140b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f114e = false;
        if (this.f110a.hasMessages(2)) {
            this.f110a.removeMessages(2);
            m95a();
        }
        this.f111b.m161n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f110a.removeMessages(2);
        m95a();
        this.f111b.m151e();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f118i) {
            this.f118i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m99a(view, menu) | this.f111b.m133a(menu);
    }

    protected void onResume() {
        super.onResume();
        this.f110a.sendEmptyMessage(2);
        this.f114e = true;
        this.f111b.m151e();
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f115f) {
            m98a(true);
        }
        Object b = m100b();
        ArrayList g = this.f111b.m154g();
        int i2;
        if (this.f121l != null) {
            int size = this.f121l.size();
            C0026y[] c0026yArr = new C0026y[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c0026yArr[i3] = (C0026y) this.f121l.m212c(i3);
            }
            i2 = 0;
            while (i < size) {
                C0026y c0026y = c0026yArr[i];
                if (c0026y.f171g) {
                    i2 = true;
                } else {
                    c0026y.m191h();
                    this.f121l.remove(c0026y.f168d);
                }
                i++;
            }
        } else {
            i2 = 0;
        }
        if (g == null && r0 == 0 && b == null) {
            return null;
        }
        C0013j c0013j = new C0013j();
        c0013j.f124a = null;
        c0013j.f125b = b;
        c0013j.f126c = null;
        c0013j.f127d = g;
        c0013j.f128e = this.f121l;
        return c0013j;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable h = this.f111b.m155h();
        if (h != null) {
            bundle.putParcelable("android:support:fragments", h);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f115f = false;
        this.f116g = false;
        this.f110a.removeMessages(1);
        if (!this.f113d) {
            this.f113d = true;
            this.f111b.m158k();
        }
        this.f111b.m156i();
        this.f111b.m151e();
        if (!this.f120k) {
            this.f120k = true;
            if (this.f122m != null) {
                this.f122m.m185b();
            } else if (!this.f119j) {
                this.f122m = m94a("(root)", this.f120k, false);
                if (!(this.f122m == null || this.f122m.f170f)) {
                    this.f122m.m185b();
                }
            }
            this.f119j = true;
        }
        this.f111b.m159l();
        if (this.f121l != null) {
            int size = this.f121l.size();
            C0026y[] c0026yArr = new C0026y[size];
            for (int i = size - 1; i >= 0; i--) {
                c0026yArr[i] = (C0026y) this.f121l.m212c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0026y c0026y = c0026yArr[i2];
                c0026y.m188e();
                c0026y.m190g();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.f115f = true;
        this.f110a.sendEmptyMessage(1);
        this.f111b.m162o();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
