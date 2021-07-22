define(["./var/arr", "./var/document", "./var/getProto", "./var/slice", "./var/concat", "./var/push", "./var/indexOf", "./var/class2type", "./var/toString", "./var/hasOwn", "./var/fnToString", "./var/ObjectFunctionString", "./var/support", "./var/isFunction", "./var/isWindow", "./core/DOMEval", "./core/toType"], function (a, d, g, q, c, o, i, b, s, h, f, n, r, k, l, e, t) {
    var u = "3.4.1", m = function (w, v) {
        return new m.fn.init(w, v)
    }, p = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
    m.fn = m.prototype = {
        jquery: u, constructor: m, length: 0, toArray: function () {
            return q.call(this)
        }, get: function (v) {
            if (v == null) {
                return q.call(this)
            }
            return v < 0 ? this[v + this.length] : this[v]
        }, pushStack: function (v) {
            var w = m.merge(this.constructor(), v);
            w.prevObject = this;
            return w
        }, each: function (v) {
            return m.each(this, v)
        }, map: function (v) {
            return this.pushStack(m.map(this, function (w, x) {
                return v.call(w, x, w)
            }))
        }, slice: function () {
            return this.pushStack(q.apply(this, arguments))
        }, first: function () {
            return this.eq(0)
        }, last: function () {
            return this.eq(-1)
        }, eq: function (v) {
            var x = this.length, w = +v + (v < 0 ? x : 0);
            return this.pushStack(w >= 0 && w < x ? [this[w]] : [])
        }, end: function () {
            return this.prevObject || this.constructor()
        }, push: o, sort: a.sort, splice: a.splice
    };
    m.extend = m.fn.extend = function () {
        var C, B, D, w, x, v, E = arguments[0] || {}, z = 1, A = arguments.length, y = false;
        if (typeof E === "boolean") {
            y = E;
            E = arguments[z] || {};
            z++
        }
        if (typeof E !== "object" && !k(E)) {
            E = {}
        }
        if (z === A) {
            E = this;
            z--
        }
        for (; z < A; z++) {
            if ((C = arguments[z]) != null) {
                for (B in C) {
                    w = C[B];
                    if (B === "__proto__" || E === w) {
                        continue
                    }
                    if (y && w && (m.isPlainObject(w) || (x = Array.isArray(w)))) {
                        D = E[B];
                        if (x && !Array.isArray(D)) {
                            v = []
                        } else {
                            if (!x && !m.isPlainObject(D)) {
                                v = {}
                            } else {
                                v = D
                            }
                        }
                        x = false;
                        E[B] = m.extend(y, v, w)
                    } else {
                        if (w !== undefined) {
                            E[B] = w
                        }
                    }
                }
            }
        }
        return E
    };
    m.extend({
        expando: "jQuery" + (u + Math.random()).replace(/\D/g, ""), isReady: true, error: function (v) {
            throw new Error(v)
        }, noop: function () {
        }, isPlainObject: function (w) {
            var x, v;
            if (!w || s.call(w) !== "[object Object]") {
                return false
            }
            x = g(w);
            if (!x) {
                return true
            }
            v = h.call(x, "constructor") && x.constructor;
            return typeof v === "function" && f.call(v) === n
        }, isEmptyObject: function (w) {
            var v;
            for (v in w) {
                return false
            }
            return true
        }, globalEval: function (v, w) {
            e(v, {nonce: w && w.nonce})
        }, each: function (y, v) {
            var x, w = 0;
            if (j(y)) {
                x = y.length;
                for (; w < x; w++) {
                    if (v.call(y[w], w, y[w]) === false) {
                        break
                    }
                }
            } else {
                for (w in y) {
                    if (v.call(y[w], w, y[w]) === false) {
                        break
                    }
                }
            }
            return y
        }, trim: function (v) {
            return v == null ? "" : (v + "").replace(p, "")
        }, makeArray: function (v, w) {
            var x = w || [];
            if (v != null) {
                if (j(Object(v))) {
                    m.merge(x, typeof v === "string" ? [v] : v)
                } else {
                    o.call(x, v)
                }
            }
            return x
        }, inArray: function (w, v, x) {
            return v == null ? -1 : i.call(v, w, x)
        }, merge: function (v, z) {
            var y = +z.length, x = 0, w = v.length;
            for (; x < y; x++) {
                v[w++] = z[x]
            }
            v.length = w;
            return v
        }, grep: function (y, v, A) {
            var x, C = [], z = 0, B = y.length, w = !A;
            for (; z < B; z++) {
                x = !v(y[z], z);
                if (x !== w) {
                    C.push(y[z])
                }
            }
            return C
        }, map: function (x, w, v) {
            var z, B, y = 0, A = [];
            if (j(x)) {
                z = x.length;
                for (; y < z; y++) {
                    B = w(x[y], y, v);
                    if (B != null) {
                        A.push(B)
                    }
                }
            } else {
                for (y in x) {
                    B = w(x[y], y, v);
                    if (B != null) {
                        A.push(B)
                    }
                }
            }
            return c.apply([], A)
        }, guid: 1, support: r
    });
    if (typeof Symbol === "function") {
        m.fn[Symbol.iterator] = a[Symbol.iterator]
    }
    m.each("Boolean Number String Function Array Date RegExp Object Error Symbol".split(" "), function (v, w) {
        b["[object " + w + "]"] = w.toLowerCase()
    });

    function j(w) {
        var v = !!w && "length" in w && w.length, x = t(w);
        if (k(w) || l(w)) {
            return false
        }
        return x === "array" || v === 0 || typeof v === "number" && v > 0 && (v - 1) in w
    }

    return m
});