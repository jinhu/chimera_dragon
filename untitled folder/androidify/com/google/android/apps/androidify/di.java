package com.google.android.apps.androidify;

import android.content.Context;
import android.os.AsyncTask;

class di extends AsyncTask {
    final /* synthetic */ Context f1600a;
    final /* synthetic */ dh f1601b;

    di(dh dhVar, Context context) {
        this.f1601b = dhVar;
        this.f1600a = context;
    }

    protected Object doInBackground(Object[] objArr) {
        this.f1601b.f1585l = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_rip1, 1);
        this.f1601b.f1586m = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_short1, 1);
        this.f1601b.f1584k = this.f1601b.f1582i.load(this.f1600a, R.raw.ogg_silence, 1);
        this.f1601b.f1587n = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_drawer_open, 1);
        this.f1601b.f1588o = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_drawer_close, 1);
        this.f1601b.f1589p = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_menu_open, 1);
        this.f1601b.f1590q = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_menu_close, 1);
        this.f1601b.f1591r = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_back, 1);
        this.f1601b.f1592s = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_new_android, 1);
        this.f1601b.f1593t = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_my_androids, 1);
        this.f1601b.f1594u = this.f1601b.f1577d.load(this.f1600a, R.raw.ogg_share, 1);
        for (dk dkVar : dk.values()) {
            C0220c.m1912a("Loading type " + dkVar.f1612i);
            this.f1601b.m1958a(this.f1600a, dkVar);
        }
        return null;
    }
}
