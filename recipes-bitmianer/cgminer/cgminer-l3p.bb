DESCRIPTION = "Cgminer DASH miner SW"
LICENSE = "CLOSED"

DEPENDS = "ncurses curl"
SRCREV = "${AUTOREV}"
SRCREV_machine = "${AUTOREV}"
PR = "r1"
SRC_URI = "git://git@gitlab.bitmain.com/antminer/cgminer-ltc.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

CFLAGS_prepend = "-I ${S}/compat/jansson-2.6/src -I ${S}/compat/libusb-1.0/libusb"


EXTRA_OECONF = " \
	     --enable-bitmain-LTC \
	     --disable-adl \
	     --disable-opencl \
	     --disable-libcurl \
	     --enable-bitmain-l3p \
	     "
do_configure_prepend() {
	echo ${BUILD_DATE} > ./build_date
	autoreconf -fiv
}

do_compile_append() {
	make api-example
}

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/api-example ${D}${bindir}/cgminer-api
}
 
inherit autotools pkgconfig
