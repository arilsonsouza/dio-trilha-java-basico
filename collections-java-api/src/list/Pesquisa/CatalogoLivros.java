package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        this.livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> perquisaPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        if (!this.livros.isEmpty()) {
            for (Livro livro : this.livros) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    resultado.add(livro);
                }
            }
        }
        return resultado;
    }

    public Livro perquisaPorTitulo(String titulo) {
        Livro resultado = null;
        if (!this.livros.isEmpty()) {
            for (Livro livro : this.livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    resultado = livro;
                    break;
                }
            }
        }
        return resultado;
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> resultado = new ArrayList<>();
        if (!this.livros.isEmpty()) {
            for (Livro livro : this.livros) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    resultado.add(livro);
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2000);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2000);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2001);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2002);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 2003);

        System.out.println(catalogoLivros.perquisaPorAutor("Autor 2"));

        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(2000, 2001));

        System.out.println(catalogoLivros.perquisaPorTitulo("Livro 1"));

    }
}
