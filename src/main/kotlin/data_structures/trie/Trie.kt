package data_structures.trie

/**
 * @author Hojat Ghasemi,
 * 2022-03-07
 * https://github.com/hojat72elect
 */
class Trie<Key> {
    private val root = TrieNode<Key>(key = null, parent = null)
// the root doesn't hold any valuable keys and also doesn't have a parent.

    fun insert(list: List<Key>) {
        var current = root
        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isTerminating = true
    }

    /**
     * Checks if a list of keys exists in this trie and last
     * key in this list is a terminating key.
     */
    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    /**
     * This one is simply for prefix matching.
     */
    fun collections(prefix: List<Key>, current: TrieNode<Key>): List<List<Key>> {
        var current = root
        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }
        return collections(prefix, current)
    }
}