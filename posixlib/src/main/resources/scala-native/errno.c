#include <errno.h>

// Omitting EDOM EILSEQ and ERANGE since they are in clib.
// Includes errno compat with Windows errors, not all of them are actually
// defined.

int scalanative_e2big() { return E2BIG; }

int scalanative_eacces() { return EACCES; }

int scalanative_eaddrinuse() { return EADDRINUSE; }

int scalanative_eaddrnotavail() { return EADDRNOTAVAIL; }

int scalanative_eafnosupport() { return EAFNOSUPPORT; }

int scalanative_eagain() { return EAGAIN; }

int scalanative_ealready() { return EALREADY; }

int scalanative_ebadf() { return EBADF; }

int scalanative_ebadmsg() { return EBADMSG; }

int scalanative_ebusy() { return EBUSY; }

int scalanative_ecanceled() { return ECANCELED; }

int scalanative_echild() { return ECHILD; }

int scalanative_econnaborted() { return ECONNABORTED; }

int scalanative_econnrefused() { return ECONNREFUSED; }

int scalanative_econnreset() { return ECONNRESET; }

int scalanative_edeadlk() { return EDEADLK; }

int scalanative_edestaddrreq() { return EDESTADDRREQ; }

int scalanative_edquot() {
#ifdef EDQUOT
    return EDQUOT;
#else
    return 0;
#endif
}

int scalanative_eexist() { return EEXIST; }

int scalanative_efault() { return EFAULT; }

int scalanative_efbig() { return EFBIG; }

int scalanative_ehostunreach() { return EHOSTUNREACH; }

int scalanative_eidrm() { return EIDRM; }

int scalanative_einprogress() { return EINPROGRESS; }

int scalanative_eintr() { return EINTR; }

int scalanative_einval() { return EINVAL; }

int scalanative_eio() { return EIO; }

int scalanative_eisconn() { return EISCONN; }

int scalanative_eisdir() { return EISDIR; }

int scalanative_eloop() { return ELOOP; }

int scalanative_emfile() { return EMFILE; }

int scalanative_emlink() { return EMLINK; }

int scalanative_emsgsize() { return EMSGSIZE; }

int scalanative_emultihup() {
#ifdef EMULTIHOP
    return EMULTIHOP;
#else
    return 0;
#endif
}

int scalanative_enametoolong() { return ENAMETOOLONG; }

int scalanative_enetdown() { return ENETDOWN; }

int scalanative_enetreset() { return ENETRESET; }

int scalanative_enetunreach() { return ENETUNREACH; }

int scalanative_enfile() { return ENFILE; }

int scalanative_enobufs() { return ENOBUFS; }

int scalanative_enodata() {
#ifdef ENODATA
    return ENODATA;
#else
    return 0;
#endif
}

int scalanative_enodev() { return ENODEV; }

int scalanative_enoent() { return ENOENT; }

int scalanative_enoexec() { return ENOEXEC; }

int scalanative_enolck() { return ENOLCK; }

int scalanative_enolink() { return ENOLINK; }

int scalanative_enomem() { return ENOMEM; }

int scalanative_enomsg() { return ENOMSG; }

int scalanative_enoprotoopt() { return ENOPROTOOPT; }

int scalanative_enospc() { return ENOSPC; }

int scalanative_enosr() {
#ifdef ENOSR
    return ENOSR;
#else
    return 0;
#endif
}

int scalanative_enostr() {
#ifdef ENOSTR
    return ENOSTR;
#else
    return 0;
#endif
}

int scalanative_enosys() { return ENOSYS; }

int scalanative_enotconn() { return ENOTCONN; }

int scalanative_enotdir() { return ENOTDIR; }

int scalanative_enotempty() { return ENOTEMPTY; }

int scalanative_enotrecoverable() { return ENOTRECOVERABLE; }

int scalanative_enotsock() { return ENOTSOCK; }

int scalanative_enotsup() { return ENOTSUP; }

int scalanative_enotty() { return ENOTTY; }

int scalanative_enxio() { return ENXIO; }

int scalanative_eopnotsupp() { return EOPNOTSUPP; }

int scalanative_eoverflow() { return EOVERFLOW; }

int scalanative_eownerdead() { return EOWNERDEAD; }

int scalanative_eperm() { return EPERM; }

int scalanative_epipe() { return EPIPE; }

int scalanative_eproto() { return EPROTO; }

int scalanative_eprotonosupport() { return EPROTONOSUPPORT; }

int scalanative_eprototype() { return EPROTOTYPE; }

int scalanative_erofs() { return EROFS; }

int scalanative_espipe() { return ESPIPE; }

int scalanative_esrch() { return ESRCH; }

int scalanative_estale() {
#ifdef ESTALE
    return ESTALE;
#else
    return 0;
#endif
}

int scalanative_etime() {
#ifdef ENOTIME
    return ETIME;
#else
    return 0;
#endif
}

int scalanative_etimedout() { return ETIMEDOUT; }

int scalanative_etxtbsy() { return ETXTBSY; }

int scalanative_ewouldblock() { return EWOULDBLOCK; }

int scalanative_exdev() { return EXDEV; }
