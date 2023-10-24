package com.example.motivationapp.data

import com.example.motivationapp.util.MotivationConstants
import kotlin.random.Random

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val listaFrase: List<Frase> = listOf(
        Frase("Não sabendo que era impossível, foi lá e fez.", happy),
        Frase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Frase("Quando está mais escuro, vemos mais estrelas!", happy),
        Frase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Frase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Frase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Frase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Frase("Você perde todas as chances que você não aproveita.", sunny),
        Frase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Frase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Frase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Frase("Se você acredita, faz toda a diferença.", sunny),
        Frase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getFrase(value: Int): String {
        val filtro = listaFrase.filter { (it.categoryId == value || value == all) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtro.size)

        // Retorna string
        return filtro[rand].descricao
    }
}

data class Frase(val descricao: String, val categoryId: Int)