import java.util.ArrayList;

class Mahasiswa {
    private String nama;
    private String nrp;
    private TaskManager taskManager;

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.taskManager = new TaskManager();
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Mahasiswa : " + nama);
        System.out.println("NRP            : " + nrp);
    }
}

class MataKuliah {
    private String nama;
    private String kode;

    public MataKuliah(String nama, String kode) {
        this.nama = nama;
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKode() {
        return kode;
    }
}

class Tugas {
    private String judul;
    private MataKuliah mataKuliah;
    private String deadline;
    private int sisaHari;
    private int tingkatKesulitan;
    private int progress;

    public Tugas(String judul, MataKuliah mataKuliah, String deadline, int sisaHari, int tingkatKesulitan) {
        this.judul = judul;
        this.mataKuliah = mataKuliah;
        this.deadline = deadline;
        this.sisaHari = sisaHari;
        this.tingkatKesulitan = tingkatKesulitan;
        this.progress = 0;
    }

    public String getJudul() {
        return judul;
    }

    public int getProgress() {
        return progress;
    }

    public String getStatus() {
        if (progress == 100) {
            return "Selesai";
        }
        if (progress > 0) {
            return "Sedang Dikerjakan";
        }
        return "Belum Selesai";
    }

    public void updateProgress(int progressBaru) {
        if (progressBaru < 0 || progressBaru > 100) {
            System.out.println("Progress harus 0 sampai 100.");
            return;
        }
        this.progress = progressBaru;
    }

    public int hitungPrioritas() {
        int urgensi = Math.max(0, 10 - sisaHari);
        int sisaProgress = (100 - progress) / 10;
        return urgensi + tingkatKesulitan + sisaProgress;
    }

    public void tampilkanRingkas() {
        System.out.println("Judul      : " + judul);
        System.out.println("Mata Kuliah: " + mataKuliah.getNama() + " (" + mataKuliah.getKode() + ")");
        System.out.println("Deadline   : " + deadline);
        System.out.println("Progress   : " + progress + "%");
        System.out.println("Status     : " + getStatus());
        System.out.println();
    }

}

class TaskManager {
    private ArrayList<Tugas> daftarTugas;

    public TaskManager() {
        daftarTugas = new ArrayList<Tugas>();
    }

    public void tambahTugas(Tugas tugas) {
        daftarTugas.add(tugas);
    }

    public void tampilkanSemuaTugas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.");
            return;
        }

        for (Tugas tugas : daftarTugas) {
            tugas.tampilkanRingkas();
        }
    }

    public void tampilkanPrioritasSemuaTugas() {
        if (daftarTugas.isEmpty()) {
            System.out.println("Belum ada tugas.");
            return;
        }

        for (Tugas tugas : daftarTugas) {
            System.out.println(tugas.getJudul() + " - Prioritas " + tugas.hitungPrioritas());
        }
        System.out.println();
    }

    public Tugas cariPrioritasTertinggi() {
        if (daftarTugas.isEmpty()) {
            return null;
        }

        Tugas prioritasTertinggi = daftarTugas.get(0);
        for (int i = 1; i < daftarTugas.size(); i++) {
            Tugas kandidat = daftarTugas.get(i);
            if (kandidat.hitungPrioritas() > prioritasTertinggi.hitungPrioritas()) {
                prioritasTertinggi = kandidat;
            }
        }
        return prioritasTertinggi;
    }
}

public class deadlineReminder {
    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa("Satya", "5027251012");

        MataKuliah strukdat = new MataKuliah("Struktur Data dan Pemrograman Berorientasi Objek", "ET4203");
        MataKuliah sisop = new MataKuliah("Sistem Operasi", "ET4201");

        Tugas tugas1 = new Tugas("Tugas Class Diagram", strukdat, "2026-03-26", 0, 10);
        Tugas tugas2 = new Tugas("Tugas Kuis", sisop, "2026-04-03", 8, 1);

        tugas1.updateProgress(50);
        tugas2.updateProgress(0);

        mahasiswa.getTaskManager().tambahTugas(tugas1);
        mahasiswa.getTaskManager().tambahTugas(tugas2);

        System.out.println("DATA MAHASISWA");
        mahasiswa.tampilkanInfo();
        System.out.println();

        System.out.println("DAFTAR SEMUA TUGAS");
        mahasiswa.getTaskManager().tampilkanSemuaTugas();

        System.out.println("TUGAS DENGAN PRIORITAS TERTINGGI");
        Tugas prioritas = mahasiswa.getTaskManager().cariPrioritasTertinggi();
        if (prioritas != null) {
            prioritas.tampilkanRingkas();
            System.out.println("Prioritas  : " + prioritas.hitungPrioritas());
        }

        System.out.println();
        System.out.println("DAFTAR PRIORITAS TUGAS");
        mahasiswa.getTaskManager().tampilkanPrioritasSemuaTugas();
    }
}
